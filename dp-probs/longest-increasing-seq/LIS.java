package src.com.pack.lis;

import java.util.Arrays;

public class LIS {

	static int res;
	
	public static void main(String[] args) {
		
		
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int n = arr.length; 
        System.out.println("Length of lis is : "
                           + lis(arr, n) + "\n");

	}

	private static int lis(int[] arr, int n) {
	
		
		int[] res = new int[n];
		Arrays.fill(res, 1);
		
		for(int i=1;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				
				if(arr[i]>arr[j] && res[i]<res[j]+1) {
					res[i] = res[j] +1;
					
				}
				
			}
			
		}
		
		return Arrays.stream(res).max().getAsInt();
	}

}
