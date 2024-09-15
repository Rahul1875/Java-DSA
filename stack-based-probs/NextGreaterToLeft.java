package src.com.pack.stack;

import java.util.Stack;

public class NextGreaterToLeft {

	public static void main(String[] args) {
		
		int arr[]= {1,3,2,4}; 
        int n = arr.length; 
        printNGL(arr,n);

	}
	
	private static void printNGL(int[] arr, int n) {
		
		int[] item = new int[n];
		Stack<Integer> stack =  new Stack<Integer>();
		
		for(int i=0;i<n;i++) {
			
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
