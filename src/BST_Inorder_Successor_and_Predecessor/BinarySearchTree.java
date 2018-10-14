package BST_Inorder_Successor_and_Predecessor;

public class BinarySearchTree {

	public String findInorderSuccPre(Node root, int target) {
		if(root == null)
			return "-1 -1";
		
		return findInorderSuccPre(root, target, -1, -1);
	}

	private String findInorderSuccPre(Node root, int target, int preTemp, int succTemp) {
		if(root == null)
			return preTemp + " " + succTemp;
		
		if(root.data < target) {
			return findInorderSuccPre(root.right, target, root.data, succTemp);
		} else if (root.data > target) {
			return findInorderSuccPre(root.left, target, preTemp, root.data);
		}
		
		if(root.right != null) {
			succTemp = findInorderSuccessorHelper(root.right);
		}
		
		if(root.left != null) {
			preTemp = findInorderPredecessorHelper(root.left);
		}
		
		return preTemp + " " + succTemp;
	}

	private int findInorderSuccessorHelper(Node root) {
		Node current = root;
		while(current.left != null) {
			current = current.left;
		}
		
		return current.data;
	}

	private int findInorderPredecessorHelper(Node root) {
		Node current = root;
		while(current.right != null) {
			current = current.right;
		}
		
		return current.data;
	}
	
}
