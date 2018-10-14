package Graph_BFS;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Integer> adj[];
	public Graph(int size) {
		adj = new LinkedList[size];
		
		for (int i = 0; i < size; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void bfs() {
		boolean[] visited = new boolean[adj.length];
		
		for (int i = 0; i < adj.length; i++) {
			if(visited[i]) {
				continue;
			}
			
			bfsHelper(i, visited);
		}
	}

	private void bfsHelper(int start, boolean[] visited) {
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		
		while(!list.isEmpty()) {
			int current = list.removeFirst();
			visited[current] = true;
			System.out.println(current);
			
			for (int i = 0; i < adj[current].size(); i++) {
				int child = adj[current].get(i);
				if(visited[child]) {
					continue;
				}
				visited[child] = true;
				list.add(child);
			}
		}
	}
}
