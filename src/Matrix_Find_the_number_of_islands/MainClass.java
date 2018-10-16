package Matrix_Find_the_number_of_islands;

public class MainClass {
	public static void main(String[] args) {
		int mat[][] = {{1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
              
		int noOfIsland = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] != 0) {
					noOfIsland += 1;
					removeIsland(mat, i, j);
				}
			}
		}
		
		System.out.println("No of islands " + noOfIsland);
	}

	private static void removeIsland(int[][] mat, int x, int y) {
		if(x < 0 || y < 0 || x == mat.length || y == mat[0].length) {
			return;
		}
		
		if(mat[x][y] == 0) {
			return;
		}
		
		mat[x][y] = 0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i==x && j==y) {
					continue;
				}
				removeIsland(mat, i , j);
			}
		}
	}
}
