package BST_Morris_traversal;

public class BinarySearchTree {

	public void morrisTraversal(Node root) {
		if(root == null)
			return;
		
		if(root.left == null) {
			System.out.println(root.data);
			morrisTraversal(root.right);
		} else {
			Node temp = previousNode(root.left, root);
			if(temp == null) {
				System.out.println(root.data);
				morrisTraversal(root.right);
			} else {
				temp.right = root;
				morrisTraversal(root.left);
			}
		}
		
	}
	
	public Node previousNode(Node root, Node parentNode) {
		Node current = root;
		while(current.right != null) {
			current = current.right;
			if(current.data == parentNode.data) {
				return null;
			}
				
		}
		return current;
	}

	
}
