package src.com.pack.mcm;

import java.util.Arrays;

public class PalindromePartitionRecurWithOptimized {

	static int[][] t ;
	
	public static void main(String[] args) {
			
		 String str = "BABABCBADCEDE"; 
		 int n = str.length(); 
	     t = new int[n+1][n+1];
	     for(int x=0;x<=n;x++) 
	     	Arrays.fill(t[x], -1);
	        System.out.println("Min cuts needed for "
	                           + "Palindrome Partitioning is : " + minPalPartion(str,0,str.length()-1)); 
	    
	}

	private static int minPalPartion(String arr, int i, int j) {
		
		if(i>=j) {
			return 0;
		}
		if(isPalindrome(arr,i,j) == true) {
			t[i][j]=0;
			return 0;
		} 
		if(t[i][j]!=-1) {
			return t[i][j];
		}
		
		int mn = Integer.MAX_VALUE;
		int count;
		for(int k=i;k<j;k++) {
			
			count = 1 + ((t[i][k] != -1) ? t[i][k]: minPalPartion(arr,i,k)) +
					((t[k+1][j] != -1) ? t[k+1][j]: minPalPartion(arr,k+1,j));
			
			//count = minPalPartion(arr,i,k)+1+minPalPartion(arr,k+1,j);
			
			mn = Integer.min(count, mn);
		}
		
		return t[i][j] =mn;
	}

	private static boolean isPalindrome(String arr, int i, int j) {
		
		while(i<j) {
			if(arr.charAt(i)!=arr.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}	
		
		return true;
	}

}
