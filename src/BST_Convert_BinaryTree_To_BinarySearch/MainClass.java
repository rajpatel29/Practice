package BST_Convert_BinaryTree_To_BinarySearch;

// Time complexity:  Quick Sort is used which takes (n^2) time. This can be done in O(nLogn) time using Heap Sort or Merge Sort.
public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(10);
		BinarySearchTree tree = new BinarySearchTree();
		
		Node node2 = new Node(2);
		Node node3 = new Node(7);
		Node node4 = new Node(8);
		Node node5 = new Node(4);

		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		

		System.out.println();
		System.out.println();
		System.out.println();
		tree.convertToBST(root);
		tree.inOrderTraversal(root);
		
	}
}
