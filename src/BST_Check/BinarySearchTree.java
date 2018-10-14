package BST_Check;

public class BinarySearchTree {
	public Node root;
	private int temp = Integer.MIN_VALUE;
	
	BinarySearchTree(Node root) {
		this.root =root;
	}
	
	public boolean isBST(Node root) {
		if(root == null)
			return true;
		
		boolean left, right = false;
		
		left = isBST(root.left);

		if(root.data < temp) {
			return false;
		}
		temp = root.data;
			
		right = isBST(root.right);
		
		
		return left && right;
	}
	
}
