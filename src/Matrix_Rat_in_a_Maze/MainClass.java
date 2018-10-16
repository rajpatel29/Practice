package Matrix_Rat_in_a_Maze;

public class MainClass {
	public static void main(String[] args) {
		int mat[][] = {{1, 0, 0, 0},
						{1, 1, 1, 1},
						{0, 1, 0, 1},
						{0, 1, 1, 1}};
		
		int dp[][] = new int[mat.length][mat[0].length];
		
		findPath(mat, dp, 0, 0, mat.length-1, mat[0].length-1);
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean findPath(int[][] mat, int[][] dp, int x, int y, int targetX, int targetY) {
		if(x < 0 || y < 0 || x == mat.length || y == mat[0].length) {
			return false;
		}
		
		if(dp[x][y] == 1) {
			return true;
		}
		
		if(mat[x][y] == 0 ) {
			return false;
		}
		
		if(x == targetX && y == targetY) {
			dp[x][y] = 1;
			return true;
		}
		
		if(findPath(mat, dp, x+1 ,y, targetX, targetY)) {
			dp[x][y] = 1;
		}
		if(findPath(mat, dp, x ,y+1, targetX, targetY)) {
			dp[x][y] = 1;
		}
		
		if(dp[x][y] == 1)
			return true;
		
		return false;
	}
}
