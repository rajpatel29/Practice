package BST_Top_Bottom_view;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(20);
		BinarySearchTree tree = new BinarySearchTree();
		
		Node node2 = new Node(8);
		Node node3 = new Node(22);
		Node node4 = new Node(5);
		Node node5 = new Node(3);
		Node node6 = new Node(25);
		Node node7 = new Node(10);
		Node node8 = new Node(14);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.right = node6;
		
		node5.left =  node7;
		node5.right = node8;
		
		tree.topView(root);
		
		tree.bottomView(root);
	}
}
