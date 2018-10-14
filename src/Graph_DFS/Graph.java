package Graph_DFS;

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
	
	
	public void dfs() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < adj.length; i++) {
			if(!map.containsKey(i))  {
				dfsHelper(i, map);
			}
		}
	}
	
	public void dfsHelper(int start, HashMap<Integer, Integer> map) {
		System.out.println("in");
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(start);
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			map.put(current, current);
			
			System.out.println(current);
			for (int i = 0; i < adj[current].size(); i++) {
				int child  = adj[current].get(i);
				if(map.containsKey(child)) {
					continue;
				}
				stack.push(child);
			}
		}
		
	}
}
