package BST_Diameter_of_Binary_Tree;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(1);
		BinarySearchTree tree = new BinarySearchTree();
		
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
//		node3.right = node6;
		
		System.out.println(tree.getDiameter(root));
	}
}
