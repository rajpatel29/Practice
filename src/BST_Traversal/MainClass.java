package BST_Traversal;

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
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("Preorder traversal");
		tree.preOrderTraversal(root);
		
		System.out.println("Postorder traversal");
		tree.postOrderTraversal(root);
		
		System.out.println("Inorder traversal");
		tree.inOrderTraversal(root);
		
		System.out.println("BFS traversal");
		tree.bfsTraversal(root);
		
		System.out.println("DFS traversal");
		tree.dfsTraversal(root);
		
		
	}
}
