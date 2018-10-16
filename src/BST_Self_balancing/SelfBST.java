package BST_Self_balancing;

import java.util.LinkedList;

public class SelfBST {
	public Node root;

	public Node insert(Node current, int num) {
		if(current == null)
			return (new Node(num));
		
		if(current.data > num) {
			current.left = insert(current.left, num);
		} else {
			current.right = insert(current.right, num);
		}
		
		int leftHeight = getHeight(current.left);
		int rightHeight = getHeight(current.right);
		
		int difference = leftHeight - rightHeight;
		
		if(difference < -1 ) {
//			right unbalanced
			if(current.right.data < num ) {
				return rightRotation(current);
			} else {
				current.right = leftRotation(current.right);
				return rightRotation(current);
			}
		} else if (difference > 1) {
//			left unbalanced
			if(current.left.data < num ) {
				return leftRotation(current);
			} else {
				current.left = rightRotation(current.left);
				return leftRotation(current);
			}
		} 
		
		
		//update
		return current;
	}
	
	public Node rightRotation(Node current) {
		Node temp = current.right;
		current.right = temp.left;
		temp.left = current;
		
		return temp;
	}
	
	
	public Node leftRotation(Node current) {
		Node temp = current.left;
		current.left = temp.right;
		temp.right = current;
		
		return temp;
	}
	
	
	public int getHeight(Node root) {
		if(root == null)
			return 0;
		
		return 1+ Math.max(getHeight(root.left), getHeight(root.right));
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
}
