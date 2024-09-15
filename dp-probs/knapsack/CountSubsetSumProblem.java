package src.com.pack.knapsack;

public class CountSubsetSumProblem {

	public static void main(String[] args) {
		
		int arr[] = { 3, 3, 3, 3 }; 
	    int n = arr.length; 
	    int x = 6; 
	    
	    //when the input array has any zeros
	    //We initialize the first column of the array acc to the formula:
	    		// 2 ^ (no of zeros in the array at that size).
	  
	    System.out.println(findCnt(arr, x, n)); 

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
