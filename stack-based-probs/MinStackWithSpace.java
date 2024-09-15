package src.com.pack.stack;

import java.util.Stack;

public class MinStackWithSpace {

	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> ss = new Stack<Integer>();
	
	private void push(int item) {
		
		s.push(item);
		if(ss.size()==0 || item<=ss.peek()) {
			ss.push(item);
		}
	}
	

	private void pop() {
		
		if(s.size()==0) {
			System.out.println("empty stack");
		}
		int ans = s.pop();
		if(ans==ss.peek()) {
			ss.pop();
		}
		
	}


	private int min() {
		
		if(ss.size()==0) {
			return -1;
		}
		return ss.peek();	
		
	}
	
	public static void main(String[] args) {
		
		MinStackWithSpace s = new MinStackWithSpace();

		s.push(6);
		System.out.println(s.min());	// prints 6

		s.push(7);
		System.out.println(s.min());	// prints 6

		s.push(8);
		System.out.println(s.min());	// prints 6

		s.push(5);
		System.out.println(s.min());	// prints 5

		s.push(3);
		System.out.println(s.min());	// prints 3

		s.pop();
		System.out.println(s.min());	// prints 5

		s.push(10);
		System.out.println(s.min());	// prints 5

		s.pop();
		System.out.println(s.min());	// prints 5

		s.pop();
		System.out.println(s.min());	// prints 6

	}

}
