package src.com.pack.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Pairs implements Comparator<Pairs> {

	int key,value;
	Pairs(){
		
	}
	Pairs(int f, int s){
		key =f;
		value =s;
	}
	
	@Override
	public int compare(Pairs o1, Pairs o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


public class TopKfrequent {

	public static void main(String[] args) {
		
		int arr[] = {1,1,1,3,2,2,4};
		int k =2;
		topK(arr, k);

	}

	private static void topK(int[] arr, int k) {
		
		PriorityQueue<Pairs> pq = new PriorityQueue<Pairs>(new Pairs());
		
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		for(int m : arr) {
			
			if(mp.containsKey(m)) {
					mp.put(m, mp.get(m)+1);
					
			} else {
				mp.put(m, 1);
			}	
		}
		
	for(Map.Entry<Integer, Integer> m : mp.entrySet()) {
		
		pq.add(new Pairs(m.getValue(),m.getKey()));
		
		if(pq.size()>k) {
			pq.poll();
		}
	}
	
	while(!pq.isEmpty()) {
		System.out.print(pq.poll().value + "->");
	}
		
	}

}


