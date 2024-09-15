package src.com.pack.bt;

public class ShortestPathRatMazeProblem {

	static int min_dist=Integer.MAX_VALUE-1;
	
	public static void main(String[] args) {
		
		
		int maze[][] =
		{
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};
		int n = maze.length;
		int m = maze[0].length;
		System.out.println("Shortest Paths : "+solveMazePath(maze,n,m));

	}
	
	private static int solveMazePath(int[][] maze, int n, int m) {
		
		int[][] path = new int[n][m];
		
		return findPath(maze,n,0,0,7,5,path,0);
		
	}

	private static int findPath(int[][] maze, int n, int x, int y,int xx, int yy, int[][] path, int dist) {
		
		if(x<0 ||x>=n || y<0 ||y>=n) {
			return 0;
		}
		
		if(x==xx && y==yy) {
			
			return min_dist = dist<min_dist?dist:min_dist;
		}
		
		if(maze[x][y]==0 || path[x][y]==1) {
			return 0;
		}
		
		path[x][y] = 1;
		
		//Left
		findPath(maze, n, x, y-1, xx, yy, path,dist+1);
		
		//Right
		findPath(maze, n, x, y+1, xx, yy, path,dist+1);
		
		//UP
		findPath(maze, n, x-1, y, xx, yy, path,dist+1);
		
		//Down
		findPath(maze, n, x+1, y, xx, yy, path,dist+1);
		
		path[x][y] =0;
		
		return min_dist;
	}

}
