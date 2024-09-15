package src.com.pack.stack;

import java.util.Stack;

// Also called as - Next Largest Element

public class NearestGreaterToRight {

	public static void main(String[] args) {
		
		int arr[]= {11, 13, 21, 3}; 
        int n = arr.length; 
        printNGR(arr, n);
		

	}

	private static void printNGR(int[] arr, int n) {
		
		int[] item = new int[n];
		Stack<Integer> stack =  new Stack<Integer>();
		
		for(int i=n-1;i>=0;i--) {
			
			if(stack.size()==0) {
				item[i] = -1;
			}
			
			else if(stack.size()>0 && arr[i]<stack.peek()) {
				item[i] = stack.peek();
			}
			
			else if(stack.size()>0 && arr[i]>=stack.peek()) {
				
				while(stack.size()>0 && arr[i]>=stack.peek()) {
					stack.pop();
				}
				
				if(stack.size()==0) {
					item[i] = -1;
				}else{
					item[i] = stack.peek();
				}
				
			}
			stack.push(arr[i]);
		}
		
		for(int x : item) {
			System.out.print(x+"->");
		}
		
	}

}
