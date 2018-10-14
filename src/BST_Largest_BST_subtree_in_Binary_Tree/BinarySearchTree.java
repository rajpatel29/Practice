package BST_Largest_BST_subtree_in_Binary_Tree;

public class BinarySearchTree {

	private int max = 0; 
	public int largestBST(Node root) {
		if (root == null)
			return 0;
		max = 0;
		
		largestBSTHelper(root);
		
		return max;
	}

	private int largestBSTHelper(Node root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		int	leftResult = largestBSTHelper(root.left);
		int rightResult = largestBSTHelper(root.right);
		
		if(leftResult != 0 && rightResult != 0) {
			boolean flag = true;
			if(root.left != null) {
				flag  = flag && root.left.data < root.data;
			} 
			if(root.right != null) {
				flag  = flag && root.data < root.right.data;
			}
			if(flag) {
				int temp = 1+leftResult+rightResult;
				max = Math.max(max, temp); 
				return temp;
			}
		}
		
		return 0;
	}
}
