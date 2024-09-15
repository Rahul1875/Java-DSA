package src.com.pack.lcs;

public class PrintingShortestSupersequence {

	public static void main(String[] args) {
		
		String X = "AGGTAB"; 
        String Y = "GXTXAYB"; 
        System.out.println(printShortestSuperSeq(X.toCharArray(), Y.toCharArray(), X.length(), Y.length())); 
		
	}
	
	
	private static String printShortestSuperSeq(char[] x, char[] y, int n, int m) {
		
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
		
		int i = n;
		int j = m;
		StringBuilder sb = new StringBuilder();
		
		while(i>0 && j>0) {
			if(x[i-1]==y[j-1]) {
				sb.append(x[i-1]);
				i--;
				j--;
			} else {
				if(t[i][j-1]>t[i-1][j]) {
					sb.append(y[j-1]);
					j--;
				} else {
					sb.append(x[i-1]);
					i--;
				}
				
			}
		}
		
		while(i>0) {
			sb.append(x[i-1]);
			i--;
		}
		
		while(j>0) {
			sb.append(y[j-1]);
			j--;
		}
		
		return sb.reverse().toString();
	}
	
	private static int max(int a, int b) {
		
		return (a>b)?a:b;
	}
	

}
