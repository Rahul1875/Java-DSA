package src.com.pack.stack;

import java.util.Stack;

public class MinStackWithNoSpace {

	private Stack<Integer> s = new Stack<>();
	private int min; 
	
	private void push(int item) {
		
		if(s.size()==0) {
			s.push(item);
			min=item;
		} else if(item>=min) {
			s.push(item);
		} else {
			s.push(2*item-min);
			min =item;
		}
	}
	

	private void pop() {
		
		if(s.size()==0) {
			System.out.println("empty stack");
		}
		int ans = s.peek();
		if(ans<min) {
			min = 2*min-ans;
		}
		s.pop();
	}


	private int min() {
		
		return min;
			
		
	}
	
	public static void main(String[] args) {
		
		MinStackWithNoSpace s = new MinStackWithNoSpace();

		s.push(6);
		System.out.println(s.min());

		s.push(7);
		System.out.println(s.min());

		s.push(5);
		System.out.println(s.min());

		s.push(3);
		System.out.println(s.min());

		s.pop();
		System.out.println(s.min());

		s.pop();
		System.out.println(s.min());
		
		

	}

}
