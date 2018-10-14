package BST_Diameter_of_Binary_Tree;

public class BinarySearchTree {
	
	public int getDiameter(Node root){
		if (root == null)
			return 0;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		return Math.max(1 + leftHeight + rightHeight , Math.max(getDiameter(root.left), getDiameter(root.right)));
	}
	
	
	public int getHeight(Node root) {
		if(root == null)
			return 0;
		
		return 1 +  Math.max(getHeight(root.left), getHeight(root.right));
	}
}
