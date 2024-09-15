package src.com.pack.heap;

import java.util.PriorityQueue;

// also called as -> Sort a nearly sorted
public class SortKSortedArray {

	public static void main(String[] args) {
		
		int k = 3; 
        int arr[] = { 2, 6, 3, 12, 56, 8 }; 
        int n = arr.length; 
        kSort(arr, n, k); 
        System.out.println("Following is sorted array"); 
        printArray(arr, n); 
		

	}

	private static void printArray(int[] arr, int n) {
			
		for(int k : arr) {
			System.out.print(k+"->");
		}
	}

	private static void kSort(int[] arr, int n, int k) {
	
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i=0;
		for(int m : arr) {
			pq.add(m);
			
			if(pq.size()>k) {
				arr[i++] = pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			arr[i++] = pq.poll();
			
		}
		
	}

}
