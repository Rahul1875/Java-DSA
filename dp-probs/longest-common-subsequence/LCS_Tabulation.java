package src.com.pack.lcs;

public class LCS_Tabulation {

	public static void main(String[] args) {
		
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int n = X.length; 
	    int m = Y.length;
	    
	    System.out.println("Length of LCS is" + " " + 
                lcsTabulation( X, Y, n, m ) );
	    
	}

	private static int lcsTabulation(char[] x, char[] y, int n, int m) {
		
		int[][] t = new int[n+1][m+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0||j==0) {
					t[i][j] =0;
				}
				else if(x[i-1] == y[j-1]) {
					t[i][j] = 1+t[i-1][j-1]; 
				} else {
					t[i][j] = max(t[i][j-1],t[i-1][j]);
				}
			}
		}		
		return t[n][m];
	}
	
	private static int max(int a, int b) {
		
		return (a>b)?a:b;
	}

}
