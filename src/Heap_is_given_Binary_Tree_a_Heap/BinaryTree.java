package Heap_is_given_Binary_Tree_a_Heap;

import java.util.LinkedList;

public class BinaryTree {
	
	
	public boolean isHeap(Node root) {
		if(root == null)
			return false;
		
		return levelOrderTraversal(root);
	}

	private boolean isHeapHealper(Node root) {
		if(root == null)
			return true;
		
		boolean answer = true;
		if(root.left != null) {
			answer = answer && (root.left.data < root.data) && isHeapHealper(root.left);
		} 
		
		if(root.right != null) {
			answer = answer && ( root.right.data < root.data ) && isHeapHealper(root.right);
		}
		
		return answer;
	}
	
	private boolean levelOrderTraversal(Node root) {
		if(root == null) {
			return false;
		}
		
		LinkedList<Node> list = new LinkedList<>();
		list.add(root);
	
		boolean answer = true;
		boolean answerHelper = false;
		while(!list.isEmpty()) {
			Node current = list.removeFirst();
			
			if(root.left == null && root.right == null) {
				answerHelper = true;
			}
			
			if(answerHelper) {
				if(current.left != null || current.right != null) {
					answer = false;
				}
			}
			
			if(current.left != null) {
				answer = answer && (current.left.data < current.data);
				list.add(current.left);
			}
			
			if(current.right != null) {
				answer = answer && (current.right.data < current.data);
				list.add(current.right);
			}
		}
		
		return answer;
	}
}
