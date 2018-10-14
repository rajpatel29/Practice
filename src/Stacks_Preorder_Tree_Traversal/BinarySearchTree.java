package Stacks_Preorder_Tree_Traversal;

import java.util.Stack;

public class BinarySearchTree {

	public void preorderTraversal(Node root) {
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		
		stack.push(root);		
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.println(current.data);
			if(current.right != null) {
				stack.push(current.right);
			}
			
			if(current.left != null) {
				stack.push(current.left);
			}
		}
	}
}
