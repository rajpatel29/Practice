// Give a 0/1 matrix to find and remove the islands. Assume that the boundaries of the matrix are 1 
// The definition of islands is surrounded by 0 

package Matrix_find_and_remove_the_islands;

public class MainClass {
	public static void main(String[] args) {
		int inputs[][] = {	{1, 1, 1, 1, 1, 1},
							{1, 0, 0, 0, 1, 1},
							{1, 0, 1, 0, 0, 1},
							{1, 0, 0, 0, 1, 1},
							{1, 1, 1, 1, 1, 1}};
		
		connectBoundry(inputs, 0, 0);
		
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < inputs[0].length; j++) {
				if(inputs[i][j] == 2) {
					inputs[i][j] = 1;
				} else if(inputs[i][j] == 1) {
					inputs[i][j] = 0;
				}
				System.out.print(inputs[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void connectBoundry(int[][] inputs, int x, int y) {
		if( x == -1 || y == -1 || x == inputs.length || y == inputs[0].length)
			return;
		
		if(inputs[x][y] == 0 || inputs[x][y] == 2)
			return;
		
		inputs[x][y] = 2;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				connectBoundry(inputs, i, j);
			}
		}
	}
}