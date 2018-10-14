// I.M.P

//Given an array of size n. The problem is to check whether the given array can represent the level order traversal 
//of a Binary Search Tree or not.

package BST_Level_Order_Check;

import java.util.LinkedList;

public class MainClass {
	public static void main(String[] args) {
		int input[] = {75, 50, 101, 35, 69, 79, 95, 21, 37};
		
		System.out.println("Is Level order " + isLevelOrderBST(input));
	}

	private static boolean isLevelOrderBST(int[] input) {
		if(input.length == 0 )
			return true;
		
		LinkedList<Node> queue = new LinkedList<>();
		int index = 1;
		
		Node root = new Node(input[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		queue.add(root);
		
		while(!queue.isEmpty() && index != input.length) {
			root = queue.getFirst();
			int first = index;
			int second = index+1;
			
			if(input[first] < root.data) {
				if(root.min < input[first] && input[first] < root.max) {
					queue.add(new Node(input[first], root.min, root.data));
					index++;
					
					if(second == input.length) {
						continue;
					}
					
					if(input[second] > root.data) {
						if(root.min < input[second] && input[second] < root.max) {
							queue.add(new Node(input[second], root.data, root.max));
							index++;
							
						} else {
							queue.removeFirst();
							continue;
						}
					}
				} else {
					queue.removeFirst();
					continue;
				}
				
			} else if (input[first] > root.data) {
				if(root.min < input[first] && input[first] < root.max) {
					queue.add(new Node(input[first], root.data, root.max));
					index++;
				} else {
					queue.removeFirst();
					continue;
				}
			}
			queue.removeFirst();
		}
		
		if(index != input.length )
			return false;
		
		return true;	
	}
}
