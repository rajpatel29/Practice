package BST_Balanced;

public class BinarySearchTree {
	public Node root;
	
	BinarySearchTree(Node root) {
		this.root =root;
	}
	
	boolean isBalanced(Node root1) { 
		if(root1 == null)
			return true;
		
		if(Math.abs(getHeight(root1.left) - getHeight(root1.right)) < 2 
				&& isBalanced(root1.left)  
				&& isBalanced(root1.right))
				return true;
		
		return false;
	}
	
	int getHeight(Node root1) {
		if(root1 == null)
			return 0;
		
		return 1 + Math.max(getHeight(root1.right), getHeight(root1.left));
	}
}
