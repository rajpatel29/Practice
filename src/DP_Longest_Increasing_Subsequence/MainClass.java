package DP_Longest_Increasing_Subsequence;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {50, 3, 10, 7, 40, 80};
		int dp[] = new int[inputs.length];
		dp[inputs.length-1] = 1;
		
		int answer = 1;
		
		for (int i = inputs.length -2; i >= 0; i--) {
			dp[i] = 1;
		
			int tempIndex = i+1;
			
			while(tempIndex != inputs.length) {
				if(inputs[i] < inputs[tempIndex]) {
					dp[i] = 1 + dp[tempIndex];
					if(answer < dp[i]) {
						answer = dp[i];
					}
					break;
				}
				tempIndex++;
			}
			
		}
		
		System.out.println("Answer = " + answer);
	}
}
