package BST_Convert_BST_To_MinHeap_In_Place;

import java.util.LinkedList;

public class BinarySearchTree {
	LinkedList<Integer> sortedNode = new LinkedList<>();
	
	public void convertToMinHeap(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root);
		
		preOrderTraversal(root);
	}
	
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		
		sortedNode.add(root.data);
		
		inOrderTraversal(root.right);
	}	
	
	public void preOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		root.data = sortedNode.removeFirst();

		preOrderTraversal(root.left);
		
		preOrderTraversal(root.right);
	}
	
	public void printInOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		printInOrderTraversal(root.left);

		System.out.println(root.data);
		
		printInOrderTraversal(root.right);
	}
}
