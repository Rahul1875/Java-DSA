package src.com.pack.graph;

public class AdjaMatrixGraphImp {

	int vertex;
	int[][] adjaMatrix;
	public AdjaMatrixGraphImp(int n) {
		vertex = n;
		adjaMatrix = new int[vertex][vertex];
	}
	
	public static void main(String[] args) {
		
		AdjaMatrixGraphImp graph = new AdjaMatrixGraphImp(5);
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
		
		for(int i=0;i<vertex;i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			for(int j =0; j<vertex; j++) {
				if(adjaMatrix[i][j]==1) {
					System.out.print(j+"->");
				}
			}
			System.out.println("\n");
		}
		
	}

	private void addEdge(int i, int j) {	
		adjaMatrix[i][j] = 1;
		adjaMatrix[j][i] = 1;
	}

}
