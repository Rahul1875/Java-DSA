package com.pack.graph;

import java.util.*;

public class GraphBFSTraversal {
	
	int vertex;
	List<Integer>[] list; 
	GraphBFSTraversal(int n){
		vertex = n;
		list = new ArrayList[vertex];
		for(int i =0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
	}

	public static void main(String[] args) {
		
		GraphBFSTraversal graph = new GraphBFSTraversal(5);
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.print("Graph Traversal : ");
		graph.printBFS(0);
		
	}

	private void printBFS(int source) {
		
		boolean[] visited = new boolean[vertex];
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[source]=true;
		q.add(source);
		
		while(!q.isEmpty()) {
			int n = q.poll();
			System.out.print(n+"=>"); 
			
			Iterator<Integer> it = list[n].iterator();
			while(it.hasNext()) {
				int i = it.next();
				if(!visited[i]) {
					visited[i]=true;
					q.add(i);
				}
			}		
		}
		
	}

	private void addEdge(int src, int dest) {
		list[src].add(dest);
		list[dest].add(src);
	}
	
}
