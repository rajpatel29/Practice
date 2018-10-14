package BST_Minimum_Value;

public class BinarySearchTree {
	
	BinarySearchTree() {
	}

	public int getMinimum(Node root) {
		if(root == null)
			return 0;
		
		Node current = root;
		
		while(current.left != null) {
			current = current.left;
		}
	
		return current.data;
	}
}
