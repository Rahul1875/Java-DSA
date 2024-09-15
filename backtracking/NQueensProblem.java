package src.com.pack.bt;

import java.util.Scanner;

public class NQueensProblem {
	
	static int[][] board;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
		board = new int[n][n];
		if(solveNQueens(0,n)) {
			System.out.println("Yes We can solve N Queens Problem");
		}
	}

	private static boolean solveNQueens(int i,int n) {
		
		if(i==n) {			
			for(int row=0;row<n;row++) {
				for(int col=0;col<n;col++) {
					if(board[row][col]==1) {
						System.out.print("Q ");
					} else {
						System.out.print("_ ");
					}
				}
				System.out.println();
			}			
			return true;
		}
		
		for(int col=0;col<n;col++) {
			
			if(isSafe(i,col,n)) {
				board[i][col] =1;
				
				boolean nextPosition = solveNQueens(i+1, n);
				if(nextPosition) {
					return true;
				}
				
				//BackTracking
				board[i][col] =0;
				
			}
		}
		return false;
		
	}

	private static boolean isSafe(int row, int col, int n) {
		
		// Check For Row
		for(int i=0;i<n;i++) {
			if(board[i][col]==1) {
				return false;
			}
		}
		
		//Check For Left Diagonal
		
		int x=row;
		int y =col;
		while(x>=0 && y>=0) {
			if(board[x][y]==1) {
				return false;
			}
			x--;
			y--;
		}
		
		//Check For Right Diagonal
		
		x=row;
		y =col;
		while(x>=0 && y<n) {
			if(board[x][y]==1) {
				return false;
			}
			x--;
			y++;
		}		
		return true;
	}

}













