//Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, 
//else return false. Expected time complexity is O(n).

package BST_Preorder_check;

import java.util.Stack;

// Time complexity O(n) time. The idea is to use a stack

public class MainClass {
	public static void main(String[] args) {
		int input[] = {35,20,10,19,25,24,29,55,40,59};
		
		System.out.println("Is preorder " + isPreorder(input));
	}

	private static boolean isPreorder(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int min = Integer.MIN_VALUE;
		stack.push(input[0]);
		
		for (int i = 1; i < input.length; i++) {
			
			if(stack.empty()) {
				stack.push(input[i]);
				continue;
			}	
			
			
			int currentTop = stack.peek();
			
			if(currentTop > input[i]) {
				if(min > input[i]) {
					return false;
				}
				
				stack.push(input[i]);
			} else {
				while(!stack.isEmpty() && stack.peek() < input[i]) {
					min = stack.pop();
				}
				stack.push(input[i]);
			}
		}
		
		return true;
	}
}
