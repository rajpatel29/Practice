package Stacks_Postorder_Tree_Traversal_2_stacks;

import java.util.Stack;

public class BinarySearchTree {

	public void postorderTraversal(Node root) {
		if(root == null)
			return;
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
					
		stack1.add(root);
		while(!stack1.isEmpty()) {
			Node current = stack1.pop();
			stack2.push(current);
			
			if(current.left != null)
				stack1.add(current.left);
			
			if(current.right != null)
				stack1.add(current.right);
		}
		
		int size = stack2.size();
		for (int i = 0; i < size; i++) {
			System.out.println(stack2.pop().data);
		}
	}
}
