package DP_Optimal_Strategy_for_Game;

public class MainClass {

	public static void main(String[] args) {
		int[] inputs = {5, 3, 7, 10};
		
		System.out.println(optimalStrategyOfGame(inputs, 0, inputs.length-1));
	}

	private static int optimalStrategyOfGame(int[] inputs, int start, int end) {
		if(start> end) 
			return 0;
		
		return Math.max(inputs[start] + Math.min(optimalStrategyOfGame(inputs, start+1, end-1), optimalStrategyOfGame(inputs, start+2, end)),
				inputs[end] + Math.min(optimalStrategyOfGame(inputs, start, end-2), optimalStrategyOfGame(inputs, start+1, end-1)));
	}

}
