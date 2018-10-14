package Graph_DijkstraShortestPath_algorithm;

import java.util.HashSet;

public class MainClass {
	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
           }; 
           
           
       MinHeap minHeap = new MinHeap(graph.length);
       minHeap.put(0, 0);
       
      for (int i = 1; i < graph.length; i++) {
    	  minHeap.put(Integer.MAX_VALUE, i);
      }
      
      HashSet<Integer> set = new HashSet<>();
      
      while(!minHeap.isEmpty()) {
    	  Node currentNode = minHeap.delete();
    	  int key = currentNode.key;
    	  int weight = currentNode.weight;
    	  set.add(key);
    	  
    	  System.out.println("Key: " + key + " weight: " + weight );
    	  
    	  for (int i = 0; i < graph.length; i++) {
			if(graph[key][i] == 0 || set.contains(i))
				continue;
			
			if(minHeap.currentWeight(i) > weight + graph[key][i]) {
				minHeap.decreaseKey(weight + graph[key][i], i);
			}
    	  }
    	  System.out.println();
    	  System.out.println();
      }
	}
}
