package DP_Dice_Throw;

public class MainClass {
	public static void main(String[] args) {
		int face = 16;
		int dice = 6;
		int total = 30;
		
		int[][] dp= new int[dice+1][total+1]; 
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(findWays(face, dice, total, dp));
		
		System.out.println("through DP " + dp[dice][total]);
	}

	private static int findWays(int face, int dice, int total, int[][] dp) {
		if(dice==0 && total==0)
			return 1;
		
		if(dice == 0 && total != 0)
			return 0;
		
		if(dice !=0 && total == 0)
			return 0;
		
		if(total < 0)
			return 0;
		
		
		int answer = 0;
		
		if(dp[dice][total] != -1) {
			return dp[dice][total];
		}
		
		int howmanyChildReturn0 = 0;
		for (int i = 1; i <= face; i++) {
			int childResult;
			
			childResult = findWays(face, dice-1, total-i, dp);
			
			if(childResult > 0) {
				howmanyChildReturn0 += childResult;
			}
		}
		dp[dice][total] = howmanyChildReturn0; 
		
		
		return howmanyChildReturn0;
	}
}
