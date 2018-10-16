// Maximum Unique Element in every subarray of size K

package Array_Sliding_Window_1;
import java.util.HashMap;
import java.util.PriorityQueue;

// Time Complexity : O(N Log K)
public class MainClass {
	public static void main(String[] args) {
		int input[] = {3, 3, 3, 4, 4, 2};
		int K = 4;
		
		// perhaps heap
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < K; i++) {
			if(map.containsKey(input[i])) {
				queue.remove(input[i]);
				int newCount = map.get(input[i]) +1;
				map.put(input[i], newCount);
			} else {
				queue.add(input[i]);
				map.put(input[i], 1);
			}
		}
		System.out.println(queue.peek());
		
		for (int i = 1; i < input.length - K + 1; i++) {
			int indexOld = i-1;
			
			if(map.get(input[indexOld]) == 1) {
				map.remove(input[indexOld]);
				queue.remove(input[indexOld]);
			} else {
				int newCount = map.get(input[indexOld]) - 1;
				map.put(input[indexOld], newCount);
				if(newCount == 1) {
					queue.add(input[indexOld]);
				}
			}
			
			int indexNew = i+K-1;
			if(map.containsKey(input[indexNew])) {
				int newCount = map.get(input[indexNew]) + 1;
				map.put(input[indexNew], newCount);
				if(newCount == 2) {
					queue.remove(input[indexNew]);
				}
			} else {
				queue.add(input[indexNew]);
				map.put(input[indexNew], 1);
			}
			
			System.out.println(queue.peek());
		}
	}
}
