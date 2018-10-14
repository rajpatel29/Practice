package DP_Longest_Path_In_Matrix;

public class MainClass {
	public static void main(String[] args) {
		int mat[][] = {{1, 2, 9},
        			   {5, 3, 8},
        			   {4, 6, 7}};
		int dp[][] = new int[mat.length][mat[0].length];
		int max = 0;;
		
		for (int x = 0; x < dp.length; x++) {
			for (int y = 0; y < dp[0].length; y++) {
				if(dp[x][y] == 0) {
					int answer = 1;
					int temp = 0;
					if((temp = findLongestPath(mat, x +1 ,y , mat[x][y], dp)) != 0) {
						answer += temp;
					} else if((temp = findLongestPath(mat, x -1 ,y , mat[x][y], dp)) != 0) {
						answer += temp;
					} else if((temp = findLongestPath(mat, x , y + 1 , mat[x][y], dp)) != 0) {
						answer += temp;
					} else if((temp = findLongestPath(mat, x, y - 1 , mat[x][y], dp)) != 0) {
						answer += temp;
					} 
					
					dp[x][y] = answer;
					
				}
				
				if(max < dp[x][y]) {
					max = dp[x][y];
				}
			}
		}
		
		System.out.println(max);
	}

	private static int findLongestPath(int[][] mat, int x, int y, int leftValue, int[][] dp) {
		if(x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] != leftValue+1)
			return 0;
		
		int answer = 1;
		int temp = 0;
		if((temp = findLongestPath(mat, x +1 ,y , mat[x][y], dp)) != 0) {
			answer += temp;
		} else if((temp = findLongestPath(mat, x -1 ,y , mat[x][y], dp)) != 0) {
			answer += temp;
		} else if((temp = findLongestPath(mat, x , y + 1 , mat[x][y], dp)) != 0) {
			answer += temp;
		} else if((temp = findLongestPath(mat, x, y - 1 , mat[x][y], dp)) != 0) {
			answer += temp;
		} 
		dp[x][y] = answer;
		
	
		return answer;
	}
}
