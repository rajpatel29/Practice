package BST_Construct_BST_from_Preorder;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {10, 5, 1, 7, 40, 50};
		BinarySearchTree tree = new BinarySearchTree();
		
		Node root = tree.constructBST(inputs);
		
		tree.inOrderTraversal(root);
	}
}
