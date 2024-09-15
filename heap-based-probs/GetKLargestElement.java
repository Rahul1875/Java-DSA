package src.com.pack.heap;

import java.util.PriorityQueue;

public class GetKLargestElement {

	public static void main(String[] args) {
		
		
		int[] arr = {7,4,6,3,9,1};
		int k =3;
		findKthLargest(arr, k);

	}

	private static void findKthLargest(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int m : arr) {
			
			pq.add(m);
			
			if(pq.size()>k) {
				pq.poll();
			}			
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+"->");
		}
		
	}
	
}
