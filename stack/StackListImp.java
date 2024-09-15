package src.com.pack.stack;


public class StackListImp {
	
	class Node {
		
		int data;
		Node link;
		Node(int k){
			data = k;
			link = null;
		}
	}

	Node top;
	
	public StackListImp() {
		top  = null;
	}
	
	public static void main(String[] args) {
		
		StackListImp stack = new StackListImp();
		stack.push(5);
		stack.push(7);
		stack.pop();
		stack.display();
		stack.peek();
	}

	private void peek() {
		
		if(top!=null) {
			System.out.println("Top elemet is :"+top.data);
		}
		
	}

	private void display() {
		
		if(top == null) {
			System.out.println("Stack is Empty");
		} else {
	           Node temp = top; 
	            while (temp != null) { 
	                System.out.printf("%d->", temp.data); 
	                temp = temp.link; 
	            } 
		}
		System.out.println();
	}

	private void push(int k) {
		
		Node temp = new Node(k);
		temp.data = k;
		temp.link = top;
		top = temp;
	}

	private void pop() {
		
		if(top==null) {
			System.out.println("Stack is Empty");
		} else {
			top = top.link;
		}
		
	}

}
