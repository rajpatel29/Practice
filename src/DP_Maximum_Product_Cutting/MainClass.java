package DP_Maximum_Product_Cutting;

public class MainClass {
	public static void main(String[] args) {
		int N = 20;
		int[] dp = new int[N+1];
		System.out.println(maxProduct(N, dp));
	}

	private static int maxProduct(int n, int[] dp) {
		if(n == 1)
			return 1;
		
		int max = 1;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, Math.max(i * (n-i) , i * maxProduct(n-i, dp)));
		}
		
		dp[n] = max;
		
		return max;
	}
}
