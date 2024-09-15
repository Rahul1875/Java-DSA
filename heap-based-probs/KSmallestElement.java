package src.com.pack.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestElement {

	public static void main(String[] args) {
		
		int[] arr = {7,4,6,3,9,1};
		int k =3;
		System.out.println("K'th Largest element in the array is : " +
				   findKthSmallest(arr, k));
		

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
