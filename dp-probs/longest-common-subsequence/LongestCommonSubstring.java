package src.com.pack.lcs;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String X = "OldSite:GeeksforGeeks.org"; 
        String Y = "NewSite:GeeksQuiz.com"; 
  
        int n = X.length(); 
        int m = Y.length(); 
  
        System.out.println("Length of Longest Common Substring is: "
                + LCSubStr(X.toCharArray(), Y.toCharArray(), n, m)); 

	}

	private static int LCSubStr(char[] x, char[] y, int n, int m) {
		
		int[][] t = new int[n+1][m+1];
		int result=0;
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0||j==0) {
					t[i][j] = 0;
				}else if(x[i-1]==y[j-1]) {
					t[i][j] =1+t[i-1][j-1];
					result = Integer.max(result,t[i][j]);
				}else {
					t[i][j] =0;
				}
			}
		}
		return result;
	}

}
