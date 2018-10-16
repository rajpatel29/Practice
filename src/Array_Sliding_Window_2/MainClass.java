// Sliding Window Maximum (Maximum of all sub arrays of size k)

package Array_Sliding_Window_2;

import java.util.PriorityQueue;

// Time complexity O(nLogk).
public class MainClass {
	public static void main(String[] args) {
		int input[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int K = 4;
		
		// perhaps heap
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
		
		for (int i = 0; i < K; i++) {
			queue.add(input[i]);
		}
		System.out.println(queue.peek());
		
		for (int i = 1; i < input.length - K + 1; i++) {
			queue.remove(input[i-1]);
			queue.add(input[i + K - 1]);
			System.out.println(queue.peek());
		}
		
	}
}
