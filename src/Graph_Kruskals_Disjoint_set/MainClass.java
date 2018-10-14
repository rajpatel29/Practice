package Graph_Kruskals_Disjoint_set;

public class MainClass {
	public static void main(String[] args) {
		int V = 4;
        int E = 5;
		
		int graph[][] = 
				{{0, 10, 6, 5}, 
                {0, 0, 0, 15}, 
                {0, 0, 0, 4}, 
                {0, 0, 0, 0}};
       
		int edge1[] = new int[E]; 
		int edge2[] = new int[E]; 
		int weight[] = new int[E]; 
		
		int edgeCounter = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if(graph[i][j] != 0 ) {
					edge1[edgeCounter] = i;
					edge2[edgeCounter] = j;
					weight[edgeCounter] = graph[i][j];
					edgeCounter++;
				}
			}
		}
		
		for (int i = 0; i < E-1; i++) {
			for (int j = i+1; j < E; j++) {
				if(weight[i] > weight[j]) {
					int edgeTemp1, edgeTemp2, weightTemp;
					
					edgeTemp1 = edge1[i];
					edge1[i] = edge1[j];
					edge1[j] = edgeTemp1;
					
					edgeTemp2 = edge2[i];
					edge2[i] = edge2[j];
					edge2[j] = edgeTemp2;
					
					weightTemp = weight[i];
					weight[i] = weight[j];
					weight[j] = weightTemp;
				}
			}
		}
		
		DisjointSet disjointSet = new DisjointSet(4);
		
		for (int i = 0; i < E; i++) {
			int currentEdge1 = edge1[i];
			int currentEdge2 = edge2[i];
			int currentWeight = weight[i];
			
			if (disjointSet.findParent(currentEdge1).data != disjointSet.findParent(currentEdge2).data) {
				System.out.println(currentEdge1 + " -- " + currentEdge2 + " == " + currentWeight );
				disjointSet.jointSet(currentEdge1, currentEdge2);
			}
		}
	}
}
