package src.com.pack.lcs;

public class SequencePatternMatching {

	public static void main(String[] args) {
		
		String a = "AXY";
		String b = "ADXCPY";
		
		System.out.println("Is String a is Subsequence of String b :" +checkPatternMatch(a,b));
		
	}

	private static boolean checkPatternMatch(String a, String b) {
		
		int lcs = lcsTabulation(a.toCharArray(), b.toCharArray(),a.length(),b.length());
		
		if(lcs == a.length()) {
			return true;
		} else {
			return false;
		}
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
