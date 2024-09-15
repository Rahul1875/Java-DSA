package src.com.pack.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair implements Comparator<Pair>{
	int first;
	int second;
	Pair(){
		
	}
	public Pair(int f, int s) {
		first = f;
		second = s;
	}
	@Override
	public int compare(Pair p1, Pair p2) {
		
		/*
		 * if(p1.first < p2.first) { return 1; } if(p1.first > p2.first) { return -1; }
		 */
		return 0;
		//return p1.first < p2.first ? 1 : -1;
	}
	
	public String toString() {
		return String.valueOf(second);
	}
	
}

public class KClosestNumber {

	public static void main(String[] args) {
		
		int[] arr = {6, 5, 7, 8, 9};
		int k = 3;
		int x =7;
	
		KClosest(arr, k, x);		

	}

	private static void KClosest(int[] arr, int k, int x) {
		
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Pair());
		
		for(int m : arr) {
			pq.add(new Pair(Math.abs(x-m),m));
		
			if(pq.size()>k) {
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+"->");
		}
		
	}
	
}
