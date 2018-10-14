package Graph_Kruskals_Disjoint_set;

public class Node {
	public int data;
	public int rank;
	public Node parent;
	
	public Node(int data) {
		this.data = data;
		this.rank = 0;
	}
}
