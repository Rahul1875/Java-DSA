package src.com.pack.stack;

public class StackImp {

	final int max = 100;
	int[] arrLen = new int[max];
	int top =-1;
			
	public static void main(String[] args) {
	
		StackImp stack = new StackImp();
		stack.push(5);
		stack.push(7);
		stack.push(8);
		stack.push(10);
		stack.peek();
		stack.pop();
		stack.isEmpty();
		stack.push(13);
		stack.peek();
		
	}

	private void isEmpty() {
		if(top < 0) {
			System.out.println("Stack is Empty");
		}
	}

	private void peek() {		
		if(top < 0) {
			System.out.println("Stack is Underflow");
		} else {
			System.out.println("Top Elemet is : " +arrLen[top]);
		}
	}

	private void pop() {
		
		if(top < 0) {
			System.out.println("Stack is Underflow");
		} else {
			System.out.println("Poped Elemet is : " +arrLen[top]);
			top--;
		}
		
	}

	private void push(int data) {
		
		if(top >= max-1) {
			System.out.println("Stack is Overflow");
		} else {
			arrLen[++top] = data;
			System.out.println("Pushed Element is : "+ arrLen[top]);
		}
		
	}

}
