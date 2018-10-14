package Cache_LRU;

import java.util.HashMap;

public class LRUCache {
	int capacity;
	Node firstElement = null;
	Node lastElement = null;
	HashMap<Integer, Node> positionMap = new HashMap<>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public void put(int key, int value) {
		if(positionMap.containsKey(key)) {
			System.out.println("Key already exists " + key);
			return;
		}
		
		
		if(capacity == 0) {
			if(firstElement == lastElement) {
				firstElement = lastElement = null;
			} else {
				positionMap.remove(firstElement.key);
				firstElement = firstElement.right;
				firstElement.left = null;
			}
			
			capacity++;
		}
		
		Node newNode = new Node(key, value);
		positionMap.put(key, newNode);
		
		if(firstElement == null && lastElement == null) {
			//first element
			firstElement = lastElement = newNode;
		} else {
			lastElement.right = newNode;
			newNode.left = lastElement;
			lastElement =  newNode;
		}
		
		
		capacity--;
	}
	
	public int get(int key) {
		if(!positionMap.containsKey(key)) {
			System.out.println("Key does not exists " + key);
			return -1;
		}
		
		Node currentNode = positionMap.get(key);
		
		if(currentNode == firstElement || currentNode == lastElement) {
			// do nothing
		} else if(currentNode == firstElement) {
			firstElement = firstElement.right;
			firstElement.left = null;
			
			currentNode.right = null;
			lastElement.right = currentNode;
			currentNode.left = lastElement;
			lastElement = currentNode;
			
		} else if(currentNode == lastElement) {
			//do nothing
		} else {
			currentNode.left.right = currentNode.right;
			currentNode.right.left = currentNode.left;
			
			currentNode.right = null;
			currentNode.left = lastElement;
			lastElement.right = currentNode;
			lastElement = currentNode;
		}
		
		return currentNode.value;
	}
}
