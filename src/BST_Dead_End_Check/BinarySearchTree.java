package BST_Dead_End_Check;

public class BinarySearchTree {
	
	BinarySearchTree() {
	}
	
	public boolean isDeadEnd(Node root) {
		if(root == null)
			return false;
		
		return isDeadEndHelper(root, 0, Integer.MAX_VALUE);
	}

	private boolean isDeadEndHelper(Node root, int minValue, int maxValue) {
		if(root == null)
			return false;
		
		if(minValue == root.data-1 && root.data+1 == maxValue) {
			return true;
		}
		
		return isDeadEndHelper(root.left , minValue, root.data) || isDeadEndHelper(root.right, root.data, maxValue);
	}
	
}
