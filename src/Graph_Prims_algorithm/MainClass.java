package Graph_Prims_algorithm;

import java.util.HashSet;

public class MainClass {
	public static void main(String[] args) {
		int graph[][] = {{0, 2, 0, 6, 0}, 
                {2, 0, 3, 8, 5}, 
                {0, 3, 0, 0, 7}, 
                {6, 8, 0, 0, 9}, 
                {0, 5, 7, 9, 0}};
           
           
       MinHeap minHeap = new MinHeap(graph.length);
       minHeap.put(0, 0);
       
      for (int i = 1; i < graph.length; i++) {
    	  minHeap.put(Integer.MAX_VALUE, i);
      }
      
      HashSet<Integer> set = new HashSet<>();
      int[] edge= new int[graph.length];
      
      
      while(!minHeap.isEmpty()) {
    	  Node currentNode = minHeap.delete();
    	  int key = currentNode.key;
    	  int weight = currentNode.weight;
    	  set.add(key);
    	  
    	  for (int i = 0; i < graph.length; i++) {
			if(graph[key][i] == 0 || set.contains(i))
				continue;
			 
			if(minHeap.currentWeight(i) > graph[key][i]) {
				edge[i] = key;
				minHeap.decreaseKey(graph[key][i], i);
			}
    	  }
    	  
    	  System.out.println("edge1: " + key + " edge2: " + edge[key] + " weight: " + weight );
    	  System.out.println();
    	  System.out.println();
      }
	}
}
