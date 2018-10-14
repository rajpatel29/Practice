package Graph_Topological_Sorting;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	LinkedList<Integer> adj[]; 
	public Graph(int size) {
		adj = new LinkedList[size];
		
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u , int v) {
		adj[u].add(v);
	}
	
	public void topologicalSort() {
		boolean visited[] = new boolean[adj.length];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < adj.length; i++) {
			if(visited[i]) {
				continue;
			}
			topologicalSortHelper(i, visited, stack);
		}
		
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			int poppedElement = stack.pop();
			System.out.println(poppedElement);
		}
	}
	
	public void topologicalSortHelper(int start, boolean[] visited, Stack<Integer> stack) {
		visited[start] = true;
		for (int i = 0; i < adj[start].size(); i++) {
			int child = adj[start].get(i);
			if(visited[child]) {
				continue;
			}
			topologicalSortHelper(child, visited, stack);
		}
		stack.add(start);
	}
}
