package src.com.pack.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {

	static int[][] t ;
	
	public static void main(String[] args) {
		
		
		int arr[] = new int[] { 1, 2, 3, 4, 3 }; 
        int n = arr.length; 
        t = new int[n+1][n+1];
        for(int x=0;x<=n;x++) 
        	Arrays.fill(t[x], -1);
        System.out.println("Minimum number of multiplications is : " + MatrixChainOrder(arr, 1, n-1)); 

	}

	private static int MatrixChainOrder(int[] arr, int i , int j) {
	
		if(i>=j) {
			return 0;
		}
		if(t[i][j]!=-1) {
			return t[i][j];
		}
		int count;
		int mn = Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			count = MatrixChainOrder(arr, i, k)+MatrixChainOrder(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
			mn = Integer.min(count, mn);
		}
		
		return t[i][j]=mn;
	}

}
