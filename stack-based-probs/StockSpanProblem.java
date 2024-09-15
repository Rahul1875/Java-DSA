package src.com.pack.stack;

import java.util.Stack;

class Pair{
	int key;
	int value;
	Pair(int f, int s){
		key = f;
		value = s;
	}
}

public class StockSpanProblem {

	public static void main(String[] args) {
		
        int price[] = {100, 80, 60, 70, 60, 75, 85}; 
        int n = price.length; 
  
        calculateSpan(price, n);
		
		

	}

	private static void calculateSpan(int[] price, int n) {
		
		Stack<Pair> stack = new Stack<Pair>();
		int[] index = new int[n];
		
		for(int i=0;i<n;i++) {
			
			if(stack.size()==0) {
				index[i] = -1;
			}
			
			else if(stack.size()>0 && price[i]<stack.peek().key) {
				index[i] = stack.peek().value;
			}
			
			else if(stack.size()>0 && price[i]>=stack.peek().key) {
				
				while(stack.size()>0 && price[i]>=stack.peek().key) {
					stack.pop();
				}
				
				if(stack.size()==0) {
					index[i] = -1;
				} else {
					index[i] = stack.peek().value;
				}
				
			}
			
			stack.push(new Pair(price[i], i));
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(i-index[i]+"->");
			
		}
		
		
	}

}
