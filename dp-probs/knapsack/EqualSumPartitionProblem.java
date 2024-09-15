package src.com.pack.knapsack;

public class EqualSumPartitionProblem {

	public static void main(String[] args) {
		
		int arr[] = {3, 1, 1, 2, 2,1}; 
        int n = arr.length; 
        if (findPartition(arr, n) == true) 
            System.out.println("Can be divided into two "+
                               "subsets of equal sum"); 
        else
            System.out.println("Can not be divided into"+
                            " two subsets of equal sum"); 
  
		
	}

	private static boolean findPartition(int[] arr, int n) {
		
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		
		if(sum%2!=0) {
			return false;
		} else {
			
			return isSubsetSum(arr, n, sum/2);
		}
		
	}
	
	private static boolean isSubsetSum(int[] val, int n, int sum) {
		
		boolean[][] t  = new boolean[n+1][sum+1];
		
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
		
		return t[n][sum];
	} 

}
