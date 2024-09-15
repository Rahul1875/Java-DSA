package src.com.pack.heap;

import java.util.PriorityQueue;

public class KLargerstElement {

	public static void main(String[] args) {
		
		int[] arr = {7,4,6,3,9,1};
		int k =3;
		System.out.println("K'th Largest element in the array is : " +
				   findKthLargest(arr, k));
	}

	private static int findKthLargest(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int m : arr) {
			
			pq.add(m);
			
			if(pq.size()>k) {
				pq.poll();
			}			
		}
		
		return pq.peek();
	}

}
