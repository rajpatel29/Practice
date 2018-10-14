package DP_Knapsack_Problem;

public class MainClass {
	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120}; 
	    int wt[] = new int[]{10, 20, 30}; 
	    int  W = 70; 
	    int n = val.length; 
	    
	    System.out.println(knapSack(W, wt, val, 0)); 
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		if(n == wt.length)
			return 0;
		
		if(w <= 0)
			return 0;
		
		if(w-wt[n] < 0) {
			return 0;
		}
		
		return Math.max(val[n] + knapSack(w-wt[n], wt,val, n + 1), knapSack(w, wt,val, n+1));		
	}
}
