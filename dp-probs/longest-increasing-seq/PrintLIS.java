package src.com.pack.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintLIS {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int n = arr.length; 
        lis(arr, n);

	}
	
	
	private static void lis(int[] arr, int n) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=0;i<n;i++) {
			list.add(new ArrayList<Integer>());
			list.get(i).add(arr[i]);
		}
			
		for(int i=1;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				
				if(arr[i]>arr[j] && list.get(i).size()<list.get(j).size()+1) {
					list.get(i).add(arr[j]);
					
				}
			}
		}
		
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (list.get(j).size() < list.get(i).size()) {
				j = i;
			}
		}

		// print LIS
		Collections.sort(list.get(j));
		System.out.println(list.get(j));
	}

}
