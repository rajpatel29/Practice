
//Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
//An empty tree is height-balanced. A non-empty binary tree T is balanced if:
//1) Left subtree of T is balanced
//2) Right subtree of T is balanced
//3) The difference between heights of left subtree and right subtree is not more than 1.

package BST_Balanced;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(1);
		BinarySearchTree tree = new BinarySearchTree(root);
		
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node4.left = node5;
		
		System.out.println(tree.isBalanced(root));
		
		
	}
}
