package BST_Largest_number_less_than_or_equal_to_N;

public class BinarySearchTree {

	public int findMaxforN(Node root, int N) {
		
		if(root == null)
			return -1;
		
		return findMaxforNHelper(root, N, -1);
	}

	private int findMaxforNHelper(Node root, int N, int i) {
		if(root == null)
			return i;
		
		if(root.data == N) {
			return N;
		} else if(root.data < N) {
			return findMaxforNHelper(root.right, N, root.data);
		} 
		
		return findMaxforNHelper(root.left, N, i);
	}
}
