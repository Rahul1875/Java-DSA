package src.com.pack.knapsack;

import java.util.Arrays;

public class MinSubsetSumdiff {

	public static void main(String[] args) {
		
		int arr[] = {3, 1, 4, 2, 2, 1}; 
        int n = arr.length; 
        System.out.print("The minimum difference"+ 
                        " between two sets is : " +  
                         findMin(arr, n));
        
		

	}

	private static int findMin(int[] arr, int n) {
		
		int sum = Arrays.stream(arr).sum();
		boolean[][] t  = new boolean[n+1][sum+1];
		
		isSubsetSum(arr,n, sum,t);
		int[] resultArr = new int[sum/2+1];
		
		for(int i=n;i<n+1;i++) {
			for(int j=0;j<sum/2+1;j++) {
				if(t[i][j]==true) {
					resultArr[j]=j;
				}
			}
		}
		
		int mn = Integer.MAX_VALUE;
		for(int i=0;i<resultArr.length;i++) {
			mn = min(mn,(sum-(2*resultArr[i])));
				
			}
		return mn;
	}
	
	private static int min(int a, int b) {
	
		return (a < b) ? a : b;
	}

	private static void isSubsetSum(int[] val, int n, int sum, boolean[][] t) {
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0 || j==0) {
					if(i==0) t[i][j] = false;
					if(j==0) t[i][j] = true;
				}
				else if(val[i-1]<=j) {
					t[i][j] = t[i-1][j-val[i-1]] || t[i-1][j];
				}else 
					t[i][j] = t[i-1][j];
			}
			
		}
	} 

}
