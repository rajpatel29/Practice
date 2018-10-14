package BST_Traversal;

import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree {
	public Node root;
	
	BinarySearchTree(Node root) {
		this.root =root;
	}
//	All five traversals require O(n) time as they visit every node exactly once.
	
	public void preOrderTraversal(Node node) {
		if(node == null)
			return;
		
		System.out.println(node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	public void postOrderTraversal(Node node) {
		if(node == null)
			return;
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.data);
	}
	
	public void inOrderTraversal(Node node) {
		if(node == null)
			return;
		
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
	
	public void bfsTraversal(Node node) {
		if(node == null)
			return;
		
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(node);
		
		while(!list.isEmpty()) {
			Node currentNode = list.remove();
			
			System.out.println(currentNode.data);
			
			if(currentNode.left != null)
				list.add(currentNode.left);
			
			if(currentNode.right != null)
				list.add(currentNode.right);
		}
	}
	
	public void dfsTraversal(Node node) {
		if(node == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		while(!stack.isEmpty()) {
			Node currentNode = stack.pop();
			System.out.println(currentNode.data);
			
			if(currentNode.right != null) {
				stack.push(currentNode.right);
			}
			
			if(currentNode.left != null) {
				stack.push(currentNode.left);
			}
		}
	}
}
