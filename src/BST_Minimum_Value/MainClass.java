package BST_Minimum_Value;

//Time Complexity: O(log n)
public class MainClass {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		Node root = new Node(20);
		Node node2 = new Node(8);
		Node node3 = new Node(22);
		Node node4 = new Node(4);
		Node node5 = new Node(12);
		Node node6 = new Node(10);
		Node node7 = new Node(14);
		

		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node5.left = node6;
		node5.right = node7;
//		
		
		System.out.println("Minimum is " + bst.getMinimum(root));
		
		
		
	}
}
