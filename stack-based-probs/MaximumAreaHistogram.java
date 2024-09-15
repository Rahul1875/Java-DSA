package src.com.pack.stack;

import java.util.Arrays;
import java.util.Stack;

class Pair2{
	int key;
	int value;
	Pair2(int f, int s){
		key = f;
		value = s;
	}
}

public class MaximumAreaHistogram {

	public static void main(String[] args) {
		
		 int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
		 int n = hist.length;
	     
	     int[] nsl = NextSmallerToLeft(hist,n);
	     int[] nsr = NextSmallerToRight(hist,n);
	     
	     int[] arr = new int[n];
	     
	     for(int i=0;i<n;i++) {
	    	 arr[i] = hist[i]*(nsr[i]-nsl[i]-1);
	     }
	     
	     System.out.println("Max. Area Histogram : "+Arrays.stream(arr).max().getAsInt());
		
	}

	private static int[] NextSmallerToLeft(int[] hist, int n) {
		
		
		Stack<Pair2> stack = new Stack<Pair2>();
		int[] index = new int[n];
		
		for(int i=0;i<n;i++) {
			
			if(stack.size()==0) {
				index[i] = -1;
			}
			
			else if(stack.size()>0 && hist[i]>stack.peek().key) {
				index[i] = stack.peek().value;
			}
			
			else if(stack.size()>0 && hist[i]<=stack.peek().key) {
				
				while(stack.size()>0 && hist[i]<=stack.peek().key) {
					stack.pop();
				}
				
				if(stack.size()==0) {
					index[i] = -1;
				} else {
					index[i] = stack.peek().value;
				}
				
			}
			
			stack.push(new Pair2(hist[i], i));
		}
		
		return index;

	}
	
	private static int[] NextSmallerToRight(int[] hist, int n) {
		
		
		Stack<Pair2> stack = new Stack<Pair2>();
		int[] index = new int[n];
		
		for(int i=n-1;i>=0;i--) {
			
			if(stack.size()==0) {
				index[i] = n;
			}
			
			else if(stack.size()>0 && hist[i]>stack.peek().key) {
				index[i] = stack.peek().value;
			}
			
			else if(stack.size()>0 && hist[i]<=stack.peek().key) {
				
				while(stack.size()>0 && hist[i]<=stack.peek().key) {
					stack.pop();
				}
				
				if(stack.size()==0) {
					index[i] = -1;
				} else {
					index[i] = stack.peek().value;
				}
				
			}
			
			stack.push(new Pair2(hist[i], i));
		}
		
		return index;
	}

}
