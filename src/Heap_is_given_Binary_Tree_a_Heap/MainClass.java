package Heap_is_given_Binary_Tree_a_Heap;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(97);
		BinaryTree tree = new BinaryTree();
		
		Node node2 = new Node(46);
		Node node3 = new Node(37);
		Node node4 = new Node(12);
		Node node5 = new Node(3);
		Node node6 = new Node(7);
		Node node7 = new Node(31);
		Node node8 = new Node(2);
		Node node9 = new Node(4);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node5.left = node8;
		node5.right = node9;
		
		
		System.out.println("Is BT is heap " + tree.isHeap(root));
		
	}
}
