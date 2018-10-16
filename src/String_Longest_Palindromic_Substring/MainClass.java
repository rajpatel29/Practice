// Given a string, find the longest substring which is palindrome. For example, if the given string is “forgeeksskeegfor”, 
// the output should be “geeksskeeg”.

package String_Longest_Palindromic_Substring;

// Time complexity: O ( n^2 )
// Auxiliary Space: O ( n^2 )
public class MainClass {
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		int n = str.length();
		
		int dp[][] = new int[n][n];
		int max = 1;
		for(int k = 0; k < dp.length; k++){
			for (int j = 0; j < dp[0].length - k  ; j++) {
//				System.out.println(j + " : " + (j+k));
				
				if(k == 0) {
					dp[j][j + k] = 1;
				} else if(k == 1) {
					if(str.charAt(j) == str.charAt(j+k)) {
						dp[j][j + k] = 1;
						max = 2;
					}
				} else {
					if(str.charAt(j) == str.charAt(j+k)) {
						if(dp[j+1][j+k-1] == 1) {
							dp[j][j + k] = 1;
							max = Math.max(max, k+1);
						}
					}
				}
			}
		}
		
		System.out.println("Maximum " + max);
	}
}
