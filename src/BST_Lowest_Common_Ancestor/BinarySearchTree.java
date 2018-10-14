package BST_Lowest_Common_Ancestor;

public class BinarySearchTree {
	public Node root;
	
	BinarySearchTree(Node root) {
		this.root =root;
	}
	
//	Time complexity of above solution is O(h) where h is height of tree. Also, the above solution requires O(h) extra space in function 
//	call stack for recursive function calls. We can avoid extra space using iterative solution.
	
	public int findLowestCommonAncestor(Node root, int num1, int num2) {
		if(root == null)
			return -1;
		
		if(root.data == num1 || root.data == num2)
			return root.data;
		
		if(num1 < root.data && root.data < num2) {
			return root.data;
		} else if(num1 < root.data && num2 < root.data) {
			return findLowestCommonAncestor(root.left , num1, num2);
		} else if(num1 > root.data && num2 > root.data) {
			return findLowestCommonAncestor(root.right , num1, num2);
		} 
		
		return -1;
	}
	
}
