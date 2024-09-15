package src.com.pack.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImpByQueue {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public static void main(String[] args) {

		StackImpByQueue a = new StackImpByQueue();
		a.push(5);
		a.push(7);
		a.push(1);
		
		System.out.println(a.pop());
		System.out.println(a.pop());
		a.push(3);
		
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());

	}

	private int pop() {

		if(q1.isEmpty())
			return -1;
		
		while(q1.size()!=1) {
			q2.add(q1.poll());
		}
		int value = q1.poll();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return value;
	}

	private void push(int value) {
		q1.add(value);
		
	}

}
