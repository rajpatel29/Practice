package DP_Egg_Dropping_Puzzle;

public class MainClass {
	public static void main(String[] args) {
		int N = 2, K = 198; 
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i < dp[0].length; i++) {
			dp[1][i] = i;
		}
		
		for (int i = 1; i < dp.length; i++) {
			dp[i][1] = 1;
		}
		
		for (int j = 2; j < dp[0].length; j++) {
			int count = 1;
			int temp = Integer.MAX_VALUE;
			for (int k = 1; k < j; k++) {
				temp = Math.min(1 + Math.max(dp[1][k-1], dp[2][j-k]), temp);
			}
			
			dp[2][j] = temp;
		}
		
		System.out.println(dp[N][K]);
	}
}
