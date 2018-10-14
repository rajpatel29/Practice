package Graph_DijkstraShortestPath_algorithm;

public class Node {
	int weight;
	int key;
	Node left;
	Node right;

	Node(int weight, int key) {
		this.weight = weight;
		this.key = key;
	}
}
