package src.com.pack.queue;

import java.util.Stack;

public class QueueImpByStack {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public static void main(String[] args) {
	
		QueueImpByStack q = new QueueImpByStack();
		q.enqueue(5);
		q.enqueue(7);
		q.enqueue(1);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

	private int dequeue() {
		
		if(!s2.isEmpty()) {
			return s2.pop();
		}
		if(s1.isEmpty()) {
			return -1;
		}
		while(s1.size()!=0) {
			s2.push(s1.pop());
		}
		
		return s2.pop();
	}

	private void enqueue(int val) {
		s1.add(val);
		
	}
}
