package src.com.pack.heap;

import java.util.PriorityQueue;

class Pair3 implements Comparable<Pair3>{
	int first;
	int second;
	Pair3(){
		
	}
	public Pair3(int f, int s) {
		first = f;
		second = s;
	}
	
	@Override
	public int compareTo(Pair3 o) {
		
		 int x1 = first * first; 
	     int y1 = second * second; 
	     int x2 = o.first * o.first; 
	     int y2 = o.second * o.second;
		
		return (x1+y1)<(x2+y2)?1:-1;
	}	
}


public class KClosestPointToOrigin {

	public static void main(String[] args) {
		
	    // x coordinate of points 
	    int x[] = { 1, -2 , 5,0}; 
	  
	    // y coordinate of points 
	    int y[] = { 3, 2, 8, 1 }; 
	    int K = 2; 
	  
	    int n = x.length; 
	  
	    kClosestPoints(x, y, n, K);
	    

	}

	private static void kClosestPoints(int[] x, int[] y, int n, int k) {
		
		PriorityQueue<Pair3> pq = new PriorityQueue<Pair3>();
		
		for(int i=0;i<n;i++) {
			
			pq.add(new Pair3(x[i],y[i]));
			if(pq.size()>k) {
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.print("("+pq.peek().first+","+pq.peek().second+") ->");
			pq.poll();
		}
		
		
	}

}
