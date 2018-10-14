// I.M.P

package Stacks_Inorder_Tree_Traversal;

import java.util.Stack;

public class BinarySearchTree {

	public void inorderTraversal(Node root) {
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		while(!stack.isEmpty() || current != null) {
			if(current == null) {
				Node temp = stack.pop();
				System.out.println(temp.data);
				current = temp.right;
				
			} else {
				stack.add(current);
				current = current.left;
			}
		}
		
	}
}
