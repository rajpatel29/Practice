package BST_Construct_BST_from_Preorder;

public class BinarySearchTree {

	public Node constructBST(int[] inputs) {
		if(inputs.length == 0)
			return null;
		
		Node root = new Node(inputs[0]);
		
		return constructBSTHelper(inputs, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
	}
	
	private Node constructBSTHelper(int[] inputs, int startIndex,  int minValue, int maxValue) {
		int i;
		for(i = startIndex ; i < inputs.length ; i++) {
			if(minValue < inputs[i] && inputs[i] < maxValue) {
				break;
			}
		}
		
		if(i == inputs.length)
			return null;
		
		Node currentNode = new Node(inputs[i]);
				
		currentNode.left = constructBSTHelper(inputs, (i+ 1), minValue, inputs[i]);
		currentNode.right = constructBSTHelper(inputs, (i+ 1), inputs[i], maxValue);
		
		return currentNode;
	}

	public void inOrderTraversal(Node node) {
		if(node == null)
			return;
		
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
}
