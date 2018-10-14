package Graph_Detect_Cycle_in_Directed_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	LinkedList<Integer> adj[];
	Set<Integer> whiteSet  = new HashSet<>();
	Set<Integer> greySet  = new HashSet<>();
	Set<Integer> blackSet  = new HashSet<>();
	
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
		for (int i = 0; i < adj.length; i++) {
			whiteSet.add(i);
		}	
		
		boolean containsCycle = false;
		for (int i = 0; i < adj.length; i++) {
			if(blackSet.contains(i)) {
				continue;
			}
			containsCycle = containsCycle || dfsHelper(i);
		}
		
		return containsCycle;
	}
	
	public boolean dfsHelper(int start) {
		whiteSet.remove(start);
		greySet.add(start);
		for (int i = 0; i < adj[start].size(); i++) {
			int child = adj[start].get(i);
			if(blackSet.contains(child)) {
				continue;
			}
			if(greySet.contains(child)) {
				return true;
			}
			dfsHelper(child);
		}
		greySet.remove(start);
		blackSet.add(start);
		
		return false;
	}
}
