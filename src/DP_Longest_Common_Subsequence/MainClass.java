package DP_Longest_Common_Subsequence;

public class MainClass {
	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		
		int[][] dp = new int[chars1.length+1][chars2.length+1]; 
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(chars1[i-1] == chars2[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
				} 
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
