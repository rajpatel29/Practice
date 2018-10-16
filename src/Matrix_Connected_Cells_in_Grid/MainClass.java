package Matrix_Connected_Cells_in_Grid;

public class MainClass {
	public static void main(String[] args) {
		int inputs[][] = {{1, 1, 0, 0},
						  {0, 1, 1, 0},
						  {0, 0, 1, 0},
						  {1, 0, 0, 0}};
		int max = 0;
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				if(inputs[i][j] != 0) {
					int tempMax = findConnectedCells(inputs, i, j);
					max = Math.max(max, tempMax);
				}
			}
		}
		
		System.out.println("Maximum connected cells " + max);
	}

	private static int findConnectedCells(int[][] inputs, int start, int end) {
		if(start < 0 || end < 0 || start == inputs.length || end == inputs[0].length ) {
			return 0;
		}
		
		if(inputs[start][end] == 0)
			return 0;
		
		int currentAnswer = 1;
		inputs[start][end] = 0;
		for (int i = start-1; i <= start+1; i++) {
			for (int j = end-1; j <= end+1; j++) {
				if(i == start && j == end) {
					continue;
				}
				currentAnswer += findConnectedCells(inputs, i, j);
			}
		}
		
		return currentAnswer;
	}
}
