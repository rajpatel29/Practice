package BST_Sorted_Sub_Sequence_Check;

public class BinarySearchTree {
	public Node root;
	
	BinarySearchTree(Node root) {
		this.root =root;
	}
	
	public boolean isSortedSubSequence(Node root, int[] seq) {
		Node indexPointer = new Node(0);
		
		inOrderTraversal(root, seq, indexPointer);
		
		if(indexPointer.data == seq.length)
			return true;
		
		return false;
	}
	
	public void inOrderTraversal(Node root, int[] seq, Node indexPointer) {
		if(root == null)
			return;
		
		inOrderTraversal(root.left, seq, indexPointer);
		
		if(root.data == seq[indexPointer.data]) {
			indexPointer.data = indexPointer.data+1;
		}	
		
		inOrderTraversal(root.right, seq, indexPointer);
		
	}
	
}
