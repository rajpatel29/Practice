//Given an array of integers of size ‘n’.
//Our aim is to calculate the maximum sum of ‘k’ 
//consecutive elements in the array.

package Array_Sliding_Window;

// Time Complexity : O(n)
public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int K = 4;
		int currentMax = 0;
		for (int i = 0; i < K; i++) {
			currentMax += inputs[i];
		}
		int temp = currentMax;
		for (int i = 1; i < inputs.length - K + 1; i++) {
			temp = temp - inputs[i-1] + inputs[i+ K -1];
			
			if(currentMax < temp)
				currentMax = temp;
		}
		
		System.out.println("Max " + currentMax);
	}
}
