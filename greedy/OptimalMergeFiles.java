package src.com.pack.greedy;

import java.util.PriorityQueue;

public class OptimalMergeFiles {

	public static void main(String[] args) {

        int size = 6; 
 
        int files[] = new int[] {12, 3, 4, 5, 6, 7 }; 
       
        System.out.println("Minimum Computations = "
                           + minComputation(size, files));

	}

	private static int minComputation(int size, int[] files) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0;i<size;i++) {
			pq.add(files[i]);
		}
		
		int count =0;
		while(pq.size()>1) {
			int temp = pq.poll() + pq.poll();
			count+=temp;
			pq.add(temp);
		}		
		return count;
	}

}
