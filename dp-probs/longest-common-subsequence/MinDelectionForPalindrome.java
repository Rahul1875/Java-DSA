package src.com.pack.lcs;

public class MinDelectionForPalindrome {
	
	// This problem is same as - Minimum number of insertions to form Palindrome

	public static void main(String[] args) {
		
	    { 
	        String str = "agbcba"; 
	        System.out.println("Minimum number " +  
	                            "of deletions to form Palindrome: "+  
	               minimumNumberOfDeletions(str)); 
	    }

	}

	private static int minimumNumberOfDeletions(String str) {
		
		
		return str.length()-lps(str,str.length());
	}
	
	
	private static int lps(String seq, int n) {
		
		StringBuilder revseq = new StringBuilder(seq).reverse();
		
		return lcsTabulation(seq.toCharArray(), revseq.toString().toCharArray(), n, revseq.length());
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
