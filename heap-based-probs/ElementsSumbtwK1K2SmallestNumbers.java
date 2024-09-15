package com.pack.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ElementsSumbtwK1K2SmallestNumbers {

	public static void main(String[] args) {
		
		int arr[] = {20, 8, 22, 4, 12, 10, 14};
		int k1 = 3;
		int k2 = 6;
		
		int num1 = findKthSmallest(arr, k1);
		int num2 = findKthSmallest(arr, k2);
		
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]>num1 && arr[i]<num2){
				sum+=arr[i];
			}
			
		}
		System.out.println("Sum of Elements btw K1th Smallest and K2th Smallest : "+sum);
	}
	
	private static int findKthSmallest(int[] arr, int k) {
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer o1, Integer o2) -> 
		//			(- Integer.compare(o1,o2)));
		
		for(int m : arr) {
			
			pq.add(m);
			
			if(pq.size()>k) {
				pq.poll();
			}			
		}
		
		return pq.peek();
		
	}

}
