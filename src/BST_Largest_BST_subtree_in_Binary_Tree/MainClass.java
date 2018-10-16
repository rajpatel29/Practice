// I.M.P

package BST_Largest_BST_subtree_in_Binary_Tree;

// Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(50);
		BinarySearchTree tree = new BinarySearchTree();
		
		Node node2 = new Node(30);
		Node node3 = new Node(60);
		Node node4 = new Node(5);
		Node node5 = new Node(20);
		Node node6 = new Node(45);
		Node node7 = new Node(70);
		Node node8 = new Node(65);
		Node node9 = new Node(80);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
//		node7.left = node8;
		node7.right = node9;
		
		System.out.println("Largest BST " + tree.largestBST(root));
		
	}
}
