package src.com.pack.bt;

public class SudokoSolver {

	static int[][] board;

	public static void main(String[] args) {

		// board = new int[][] { {1,3,0,4}, {2,0,3,1}, {0,1,0,2}, {4,0,1,0} };

		
		board = new int[][] { 
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
		};

		int N = board.length;

		if (solveSudoku(N)) {
			System.out.println("Yes");
			// print solution
			print(N);
		} else {
			System.out.println("No solution");
		}

	}

	private static boolean solveSudoku(int n) {

		int row = -1; 
		int col = -1; 
		boolean isEmpty = true; 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) { 
					row = i; 
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}
		if (isEmpty) {
			return true;
		}

		for (int num = 1; num <= n; num++) {

			if (isSafe(row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(n)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}

		return false;
	}

	private static boolean isSafe(int row, int col, int num) {

		// Check Row Safe
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == num) {
				return false;
			}
		}

		// Check Column Safe
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num) {
				return false;
			}
		}

		// Check Box Safe
		int sqrt = (int) Math.sqrt(board.length);
		int rs = row - row % sqrt;
		int cs = col - col % sqrt;

		for (int i = rs; i < rs + sqrt; i++) {
			for (int j = cs; j < cs + sqrt; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public static void print(int N) {

		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
}
