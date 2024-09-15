package src.com.pack.bt;

public class RatMazeProblem {

	static int[][] path;
	public static void main(String[] args) {
		
		
		int[][] maze = {{1,1,0},{1,1,0},{0,1,1}};
		int n = maze.length;
		int m = maze[0].length;
		path = new int[n][m];
		
		if(solveMazePath(maze,n,m)) {
			System.out.println("There exist a Path From Source to Destination");
		}else {
			System.out.println("NO Path");
		}
		
		System.out.println("Path is : ");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static boolean solveMazePath(int[][] maze, int n, int m) {
		
		
		return findPath(maze,n,0,0);
		
	}

	private static boolean findPath(int[][] maze, int n, int x, int y) {
		
		if(x<0 ||x>=n || y<0 ||y>=n) {
			return false;
		}
		
		if(x==n-1 && y==n-1) {
			return true;
		}
		
		if(maze[x][y]==0 || path[x][y]==1) {
			return false;
		}
		
		path[x][y] = 1;
		
		//Left
		if(findPath(maze, n, x, y-1)) {
			return true;
		}
		
		//Right
		if(findPath(maze, n, x, y+1)) {
			return true;
		}
		
		//UP
		if(findPath(maze, n, x-1, y)) {
			return true;
		}
		
		//Down
		if(findPath(maze, n, x+1, y)) {
			return true;
		}
		
		
		//BackTracking
		path[x][y] =0;
		
		return false;
	}

}














