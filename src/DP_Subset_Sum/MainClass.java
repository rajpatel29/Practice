package DP_Subset_Sum;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] =  {2, 3, 5, 7, 10};
		int target = 14;
		int dp[][] = new int[inputs.length+1][target+1];
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(inputs[i-1] == j) {
					dp[i][j] = 1;
				} else if(j < inputs[i-1]) {
					dp[i][j] = dp[i-1][j];
				} else {
					if(dp[i-1][j  - inputs[i-1]] == 1 || dp[i-1][j] == 1) {
						dp[i][j] = 1;
					}
				}
			}
		}
		
		if(dp[inputs.length-1][target] == 1) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
