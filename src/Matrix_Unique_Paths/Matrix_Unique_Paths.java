package Matrix_Unique_Paths;
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 

public class Matrix_Unique_Paths {
	public static void main(String[] args) {
		 int m = 7, n = 3;
		 
		 int[][] dp = new int[n][m];
		 
		 for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		 }
		 
		 for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = 1;
		 }
		 
		 for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		 }
		 
		 System.out.println();
		 System.out.println("Done " + dp[n-1][m-1] );
	}
}
