package BST_Template;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(5);
		BinarySearchTree tree = new BinarySearchTree();
		
		Node node2 = new Node(2);
		Node node3 = new Node(12);
		Node node4 = new Node(1);
		Node node5 = new Node(3);
		Node node6 = new Node(9);
		Node node7 = new Node(21);
		Node node8 = new Node(19);
		Node node9 = new Node(25);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node7.left = node8;
		node7.right = node9;
		
		
		
		
	}
}
