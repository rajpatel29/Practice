package Cache_LFU;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache {
	private int capacity;
	HashMap<Integer, Integer> values = new HashMap<>();
	HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
	
	//frequency and key
	HashMap<Integer, LinkedList<Integer>> evictionMap = new HashMap<>();
	int minFrequencyKey = 0;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public void put(int key, int value) {
		//eviction
		if(capacity == 0) {
			LinkedList<Integer> list = evictionMap.get(minFrequencyKey);
			int removedKey = list.removeFirst();
			if(list.isEmpty()) {
				frequency.remove(minFrequencyKey);
			}
			values.remove(removedKey);
			frequency.remove(removedKey);
			capacity++;
			System.out.println("removed key " + removedKey);
		}
		
		values.put(key, value);
		frequency.put(key, 1);
		if(evictionMap.containsKey(1)) {
			evictionMap.get(1).add(key);
		} else {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(key);
			evictionMap.put(1, list);	
		}
		minFrequencyKey = 1;
		
		capacity--;
	}
	
	public int get(int key) {
		if (!values.containsKey(key)) {
			System.out.println("Key does not exists");
			return -1;
		}
		
		int currentFrequency = frequency.get(key);
		evictionMap.get(currentFrequency).remove(new Integer(key));
		frequency.put(key, currentFrequency + 1);
		
		if(evictionMap.get(currentFrequency).size() == 0) {
			evictionMap.remove(currentFrequency);
			
			if(minFrequencyKey == currentFrequency) {
				minFrequencyKey = currentFrequency + 1;
			}
		}
		
		if(evictionMap.containsKey(currentFrequency + 1)) {
			evictionMap.get(currentFrequency + 1).add(key);
		} else {
			LinkedList<Integer> temp = new LinkedList<>();
			temp.add(key);
			evictionMap.put(currentFrequency + 1, temp);
		}
		
		return values.get(key);
	}
}
