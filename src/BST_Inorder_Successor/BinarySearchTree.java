package BST_Inorder_Successor;

public class BinarySearchTree {

	public int findInorderSuccessor(Node root, int target) {
		if(root == null)
			return -1;
		
		return findInorderSuccessorHelper(root, target, -1);
	}

	private int findInorderSuccessorHelper(Node root,int target, int tempSuccessor) {
		if(root == null)
			return -1;
		
		if(root.data < target) {
			return findInorderSuccessorHelper(root.right, target, tempSuccessor);
		} else if (root.data > target) {
			return findInorderSuccessorHelper(root.left, target, root.data);
		} 
		
		// root.data == target
		if(root.right == null)
			return tempSuccessor;
		
		return nextHighestNumber(root.right);
	}
	
	private int nextHighestNumber(Node root) {
		Node current = root;
		
		while(current.left != null) {
			current = current.left;
		}
		return current.data;
	}
}
