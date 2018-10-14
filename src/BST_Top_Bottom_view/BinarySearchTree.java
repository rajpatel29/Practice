package BST_Top_Bottom_view;

import java.util.HashMap;
import java.util.LinkedList;

public class BinarySearchTree {
	
	public void bottomView(Node node) {
		if(node == null)
			return;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		LinkedList<Node> nodeList = new LinkedList<>();
		LinkedList<Integer> indexList = new LinkedList<>();
		
		nodeList.add(node);
		indexList.add(0);
		
		while(!nodeList.isEmpty()) {
			Node currentNode = nodeList.removeFirst();
			int currentIndex = indexList.removeFirst();
		
			map.put(currentIndex, currentNode.data);
			
			if(currentNode.left != null) {
				nodeList.add(currentNode.left);
				indexList.add(currentIndex - 1);
			}
			
			if(currentNode.right != null) {
				nodeList.add(currentNode.right);
				indexList.add(currentIndex + 1);
			}
		}
		
		System.out.println(map);
	}
	
	public void topView(Node node) {
		if(node == null)
			return;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		LinkedList<Node> nodeList = new LinkedList<>();
		LinkedList<Integer> indexList = new LinkedList<>();
		
		nodeList.add(node);
		indexList.add(0);
		while(!nodeList.isEmpty()) {
			Node currentNode = nodeList.removeFirst();
			int currentIndex = indexList.removeFirst();
			
			if(!map.containsKey(currentIndex)) {
				System.out.println(currentNode.data);
				map.put(currentIndex, currentNode.data);
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
	}
}
