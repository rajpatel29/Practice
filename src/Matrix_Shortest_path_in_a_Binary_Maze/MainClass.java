package Matrix_Shortest_path_in_a_Binary_Maze;

public class MainClass {
	public static void main(String[] args) {
		int mat[][]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                		{1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                		{1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                		{0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                		{1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                		{1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                		{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                		{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                		{1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
		int dp[][] = new int[mat.length][mat[0].length];
		
		
		int x = 0;
		int y = 0;
		dp[0][0] =-1;
		findPath(mat, dp, x +1, y, 1);
		findPath(mat, dp, x -1, y, 1);
		findPath(mat, dp, x, y+1, 1);
		findPath(mat, dp, x, y-1, 1);
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(dp[8][1]);
	}

	private static void findPath(int[][] mat, int[][] dp, int x, int y, int distance) {
		if(x < 0 || y < 0 || x == mat.length || y == mat[0].length) {
			return;
		}
		
		if(mat[x][y] == 0) {
			return;
		}
		
		if(dp[x][y] != 0 && distance >= dp[x][y]) {
			return;
		}
		dp[x][y] = distance;
		
		findPath(mat, dp, x +1, y, distance+1);
		findPath(mat, dp, x -1, y, distance+1);
		findPath(mat, dp, x, y+1, distance+1);
		findPath(mat, dp, x, y-1, distance+1);
	}
}
