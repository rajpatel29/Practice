package BST_Convert_BinaryTree_To_BinarySearch;

import java.util.Collections;
import java.util.LinkedList;

public class BinarySearchTree {
	LinkedList<Integer> sortedNode = new LinkedList<>();
	
	public Node convertToBST(Node root) {
		if(root == null) {
			return null;
		}
		
		inOrderTraversal(root);
		
		Collections.sort(sortedNode);
		System.out.println();
		System.out.println();
		System.out.println(sortedNode);
		return inOrderTraversal2(root);
	}
	
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		
		sortedNode.add(root.data);
		
		inOrderTraversal(root.right);
	}
	
	public Node inOrderTraversal2(Node root) {
		if(root == null) {
			return null;
		}
		
		inOrderTraversal2(root.left);
		
		root.data = sortedNode.removeFirst();
		System.out.println(root.data);
		
		inOrderTraversal2(root.right);
		
		return root;
	}
}
