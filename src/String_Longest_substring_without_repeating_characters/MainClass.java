// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, 
// with length 6. For “BBBB” the longest substring is “B”, with length 1. For “GEEKSFORGEEKS”, 
// there are two longest substrings shown in the below diagrams, with length 7.

package String_Longest_substring_without_repeating_characters;

import java.util.HashMap;

public class MainClass {
	public static void main(String[] args) {
		String input = "ABDEFGABEF";
		HashMap<Character,  Integer> map = new HashMap<>();
		
		int max = 0;
		int lastPoisition = 0;
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			
			if(map.containsKey(currentChar)) {
				int newPosition = map.get(currentChar) + 1;
				if(lastPoisition > newPosition) {
					
				} else {
					lastPoisition = newPosition;
				}
				map.put(currentChar, i);
				max = Math.max(max, i - lastPoisition +1);
			} else {
				map.put(currentChar, i);
				max = Math.max(max, i - lastPoisition +1);
			}
		}
		
		System.out.println("Maximum is " + max);
	}
}
