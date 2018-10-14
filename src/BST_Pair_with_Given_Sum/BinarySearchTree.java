package BST_Pair_with_Given_Sum;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {

	public void getPair(Node root, int target) {
		if(root == null)
			return;
		
		Set<Integer> set = new HashSet<>();
		inorderTraversal(root, set, target);
		
	}

	private void inorderTraversal(Node root, Set<Integer> set, int target) {
		if(root == null)
			return;
		
		inorderTraversal(root.left , set, target);
		
		if(set.contains(root.data)) {
			System.out.println(root.data + " " + (target - root.data));
		} else {
			set.add(target - root.data);
		}
		
		inorderTraversal(root.right , set, target);
	}
}
