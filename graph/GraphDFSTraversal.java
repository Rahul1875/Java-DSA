package com.pack.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GraphDFSTraversal {

	int vertex;
	List<Integer>[] list;
	GraphDFSTraversal(int n){
	
		vertex = n;
		list = new ArrayList[vertex];
		for(int i=0;i<n;i++) {
			list[i]=new ArrayList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		
		GraphDFSTraversal graph = new GraphDFSTraversal(5);
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
		
		graph.printDFS(0);
		
	}
	
	private void printDFS(int source) {
		
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[vertex];
		
		visited[source] = true;
		stack.add(source);
		
		while(!stack.isEmpty()) {		
			int node = stack.pop();
			System.out.print(node+"=>");
			
			Iterator<Integer> it = list[node].iterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n]=true;
					stack.push(n);
				}
			}
			
		}
		
	}

	private void addEdge(int source, int dest) {	
		list[source].add(dest);
		list[dest].add(source);
		
	}

}
