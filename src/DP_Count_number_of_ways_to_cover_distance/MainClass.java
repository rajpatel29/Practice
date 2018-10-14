package DP_Count_number_of_ways_to_cover_distance;

public class MainClass {
	public static void main(String[] args) {
		int dist = 78; 
        System.out.println(printCountRec(dist)); 
	}

	private static int printCountRec(int dist) {
		int[] dp = new int[dist+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		if(dist >= 4) {
			for (int i = 4; i <= dist; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
		}
		
		return dp[dist];
	}
}
