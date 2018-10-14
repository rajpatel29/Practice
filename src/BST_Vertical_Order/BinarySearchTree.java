package BST_Vertical_Order;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree {
	
	public void topView(Node node) {
		if(node == null)
			return;
		
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
		LinkedList<Node> nodeList = new LinkedList<>();
		LinkedList<Integer> indexList = new LinkedList<>();
		
		nodeList.add(node);
		indexList.add(0);
		while(!nodeList.isEmpty()) {
			Node currentNode = nodeList.removeFirst();
			int currentIndex = indexList.removeFirst();
			
			if(!map.containsKey(currentIndex)) {
				LinkedList<Integer> list = new LinkedList<>();
				list.add(currentNode.data);
				map.put(currentIndex, list);
			} else {
				map.get(currentIndex).add(currentNode.data);
			}
			
			if(currentNode.left != null) {
				nodeList.add(currentNode.left);
				indexList.add(currentIndex - 1);
			}
			
			if(currentNode.right != null) {
				nodeList.add(currentNode.right);
				indexList.add(currentIndex + 1);
			}
		}
		
		for (int key : map.keySet()) {
			System.out.println( map.get(key));
		}
	}
}
