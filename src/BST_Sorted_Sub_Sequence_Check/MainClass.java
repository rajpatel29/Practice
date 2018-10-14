package BST_Sorted_Sub_Sequence_Check;

public class MainClass {
	public static void main(String[] args) {
		int seq[] = {4, 6, 8, 12, 13};
		
		Node root = new Node(8);
		BinarySearchTree tree = new BinarySearchTree(root);
		
		Node node2 = new Node(3);
		Node node3 = new Node(10);
		Node node4 = new Node(1);
		Node node5 = new Node(6);
		Node node6 = new Node(14);
		Node node7 = new Node(4);
		Node node8 = new Node(7);
		Node node9 = new Node(13);
		

		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.right = node6;
		
		node5.left = node7;
		node5.right = node8;
		
		node6.left = node9;
		
		System.out.println(tree.isSortedSubSequence(root, seq));
		
		
		
	}
}
