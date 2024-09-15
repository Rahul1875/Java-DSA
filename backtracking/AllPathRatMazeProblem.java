package src.com.pack.bt;

public class AllPathRatMazeProblem {

	public static void main(String[] args) {
		
		int[][] maze = {{1,1,0},{1,1,0},{0,1,1}};
		int n = maze.length;
		int m = maze[0].length;
		solveMazePath(maze,n,m);

	}

	private static void solveMazePath(int[][] maze, int n, int m) {
		
		int[][] path = new int[n][m];
		System.out.println("Path is : ");
		findPath(maze,n,0,0,path);
		
	}

	private static void findPath(int[][] maze, int n, int x, int y, int[][] path) {
		
		if(x<0 ||x>=n || y<0 ||y>=n) {
			return;
		}
		
		if(x==n-1 && y==n-1) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<path[0].length;j++) {
					System.out.print(path[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------");
			return;
		}
		
		if(maze[x][y]==0 || path[x][y]==1) {
			return;
		}
		
		path[x][y] = 1;
		
		//Left
		findPath(maze, n, x, y-1, path);
		
		//Right
		findPath(maze, n, x, y+1, path);
		
		//UP
		findPath(maze, n, x-1, y, path);
		
		//Down
		findPath(maze, n, x+1, y, path);
		
		path[x][y] =0;
		
		return;
		
		
		
	}
	
}
