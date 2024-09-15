package src.com.pack.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Pair2 implements Comparator<Pair2>{
	int first;
	int second;
	Pair2(){
		
	}
	public Pair2(int f, int s) {
		first = f;
		second = s;
	}
	@Override
	public int compare(Pair2 p1, Pair2 p2) {
		
		return p1.first < p2.first ? 1 : -1;
	}
	
	public String toString() {
		return String.valueOf(second);
	}
	
}

public class FrequencySort {

	public static void main(String[] args) {
		
		int arr[] = {1,1,1,3,2,3,4};
		freqSort(arr);

	}

	private static void freqSort(int[] arr) {
		
		PriorityQueue<Pair2> pq = new PriorityQueue<Pair2>(new Pair2());
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		for(int m : arr) {
			
			if(mp.containsKey(m)) {
					mp.put(m, mp.get(m)+1);
					
			} else {
				mp.put(m, 1);
			}	
		}
		
		for(Map.Entry<Integer, Integer> m : mp.entrySet()) {
			
			pq.add(new Pair2(m.getValue(),m.getKey()));
			
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll().second + "->");
		}
		
	}

}
