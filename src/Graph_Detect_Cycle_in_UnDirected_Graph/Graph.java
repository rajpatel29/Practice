package Graph_Detect_Cycle_in_UnDirected_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	LinkedList<Integer> adj[];
	
	public Graph(int size) {
		adj = new LinkedList[size];
		
		for (int i = 0; i < size; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u , int v) {
		adj[u].add(v);
	}
	
	
	public boolean dfs() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		boolean containsCycle = false;
		for (int i = 0; i < adj.length; i++) {
			if(!map.containsKey(i))  {
				containsCycle = containsCycle || dfsHelper(i, map);
			}
		}
		return containsCycle;
	}
	
	public boolean dfsHelper(int start, HashMap<Integer, Integer> map) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(start);
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			map.put(current, current);
			
			for (int i = 0; i < adj[current].size(); i++) {
				int child  = adj[current].get(i);
				if(map.containsKey(child)) {
					return true;
				}
				stack.push(child);
			}
		}
		
		return false;
	}
}
