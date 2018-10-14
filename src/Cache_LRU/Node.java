package Cache_LRU;

public class Node {
	public int key;
	public int value;
	public Node right;
	public Node left;
	
	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
