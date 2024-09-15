package src.com.pack.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjaListGraphImp {
	
	int vertex;
	List<Integer>[] list;
	
	public AdjaListGraphImp(int n) {
		vertex = n;
		list = new ArrayList[vertex];
		for(int i =0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		
		AdjaListGraphImp graph = new AdjaListGraphImp(5);
		
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
		graph.printGraph();
	}

	private void printGraph() {
		
		//System.out.println("list"+list);
		
		for(int i=0; i<list.length;i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			for(int node : list[i]) {
				System.out.print(node+"->");	
			}
			System.out.println("\n");
		}
	}

	private void addEdge(int source, int dest) {
		
		list[source].add(dest);
		list[dest].add(source);
		
	}

}
