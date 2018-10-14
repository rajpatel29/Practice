package Graph_Detect_Cycle_in_UnDirected_Graph;

public class MainClass {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		
		graph.addEdge(1, 0); 
		graph.addEdge(0, 2); 
		graph.addEdge(2, 0); 
		graph.addEdge(0, 3); 
		graph.addEdge(3, 4); 
        
		System.out.println("Graph contains cycle? " + graph.dfs());
		
		Graph graph2 = new Graph(3);
		graph2.addEdge(0, 1); 
		graph2.addEdge(1, 2);
		
		System.out.println("Graph contains cycle? " + graph2.dfs());
	}
}
