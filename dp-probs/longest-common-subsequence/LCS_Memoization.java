package src.com.pack.lcs;

import java.util.Arrays;

public class LCS_Memoization {

	static int[][] t;
	
	public static void main(String[] args) {
		
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int n = X.length; 
	    int m = Y.length; 
	    t = new int[n+1][m+1];
	       for(int x=0;x<t.length;x++)
	    	    Arrays.fill( t[x], -1);
	  
	    System.out.println("Length of LCS is" + " " + 
	                                  lcsMemoization( X, Y, n, m ) );

	}

	private static int lcsMemoization(char[] x, char[] y, int n, int m) {
		
		if(n==0 || m==0) {
			return 0;
		}
		
		if(t[n][m]!=-1) {
			return t[n][m];
		}
		
		if(x[n-1] == y[m-1]) {
			return t[n][m] = 1+lcsMemoization(x,y,n-1,m-1);
		} else {
			return t[n][m] = max(lcsMemoization(x,y,n, m-1),lcsMemoization(x,y,n-1,m));
		}
	}

	private static int max(int a, int b) {
		
		return (a>b)?a:b;
	}

}
