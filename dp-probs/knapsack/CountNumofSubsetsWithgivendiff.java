package src.com.pack.knapsack;

import java.util.Arrays;

// /this is also Target Sum Problem:

public class CountNumofSubsetsWithgivendiff {

	public static void main(String[] args) {
		
		int arr[] = {1,1,2,3}; 
		int diff = 1;
        int n = arr.length; 
        System.out.print("The number of subsets"+ 
                        " with given difference : " +  
                         countSubsets(arr, diff, n));

	}

	private static int countSubsets(int[] arr, int diff, int n) {
		
		int sum = (diff + Arrays.stream(arr).sum())/2;
		
		return findCnt(arr, sum, n);
	}
	
	private static int findCnt(int[] arr, int sum, int n) {
		
		int[][] t  = new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0 || j==0) {
					if(i==0) t[i][j] = 0;
					if(j==0) t[i][j] = 1;
				}
				else if(arr[i-1]<=j) {
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}else 
					t[i][j] = t[i-1][j];
			}
			
		}
		
		return t[n][sum];
		
	}

}
