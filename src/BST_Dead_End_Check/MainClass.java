package BST_Dead_End_Check;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(8);
		BinarySearchTree tree = new BinarySearchTree();
		
		Node node2 = new Node(5);
		Node node3 = new Node(9);
		Node node4 = new Node(2);
		Node node5 = new Node(7);
		Node node6 = new Node(1);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node4.left = node6;
		
		System.out.println("Contains dead end? " + tree.isDeadEnd(root));
	
	}
}
