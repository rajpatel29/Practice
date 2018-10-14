package BST_Symmetric_Tree;

public class BinarySearchTree {
	public Node root;
	
	BinarySearchTree(Node root) {
		this.root =root;
	}
	
	boolean isSymmetric(Node root1, Node root2) { 
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2 != null )
			return root1.data == root2.data && isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
		
		return false;
	}
}
