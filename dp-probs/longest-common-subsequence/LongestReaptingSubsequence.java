package src.com.pack.lcs;

public class LongestReaptingSubsequence {

	public static void main(String[] args) {
	      String str = "aabebcdd"; 
	        System.out.println("The length of the largest subsequence that"
	            +" repeats itself is : "+findLongestRepeatingSubSeq(str)); 

	}

	private static int findLongestRepeatingSubSeq(String str) {
		
		int n = str.length();
		return lcsTabulation(str.toCharArray(), str.toCharArray(), n, n);
	}
	
	private static int lcsTabulation(char[] x, char[] y, int n, int m) {
		
		int[][] t = new int[n+1][m+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0||j==0) {
					t[i][j] =0;
				}
				else if(x[i-1] == y[j-1] && i !=j) {
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
