package Graph_Kruskals_Disjoint_set;

import java.util.HashMap;
import java.util.LinkedList;

public class DisjointSet {
	int size;
	LinkedList<Node> allSets = new LinkedList<>();
	HashMap<Integer, Node> map = new HashMap<>();

	public DisjointSet(int size) {
		this.size = size; 
		
		for (int i = 0; i < size; i++) {
			Node node = new Node(i);
			node.parent = node;
			allSets.add(node);
			map.put(i, node);
		}
	}
	
	public void jointSet(int num1, int num2) {
		Node node1 = findParent(num1);
		Node node2 = findParent(num2);
		
		if (node1.rank >= node2.rank) {
			node2.parent = node1;
		} else {
			node1.parent = node2;
		}
	}
	
	
	public Node findParent(int target) {
		Node current = map.get(target);
		LinkedList<Node> subChilds = new LinkedList<>();
		
		while(current.data != current.parent.data) {
			subChilds.add(current);
			current = current.parent;
		}

		for (int i = 0; i < subChilds.size(); i++) {
			Node child = subChilds.removeFirst();
			child.parent = current;
		}
		
		return current;
	}
}
