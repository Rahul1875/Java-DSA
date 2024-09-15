package src.com.pack.stack;

import java.util.Stack;

class Node{
	int data;
	Node next;
	Node(int k){
		data = k;
		next = null;
	}
}


public class ReverseListByStack {

	Node head;

	public static void main(String[] args) {
		
		ReverseListByStack list = new ReverseListByStack();
		 list.head = new Node(1); 
	     list.head.next = new Node(2); 
	     list.head.next.next = new Node(3); 
	     list.head.next.next.next = new Node(4); 
	     list.head.next.next.next.next = new Node(5);
	     display(list);
	     System.out.println();
	     list = reverse(list);
	     display(list);
	     
	}
	
	private static void display(ReverseListByStack list) {
	
		Node temp = list.head;
		while(temp!=null) {
			System.out.print("->"+temp.data);
			temp = temp.next;
		}
		
	}

	private static ReverseListByStack reverse(ReverseListByStack list) {
		
		Stack<Node> stack = new Stack<Node>();
		Node temp = list.head;
		if(list.head ==null) {
			return null;
		} else {				
			while(temp!=null) {
				stack.push(temp);
				temp = temp.next;
			}
		}

		temp = stack.pop();
		list.head = temp;
		while(!stack.isEmpty()) {
			temp.next = stack.pop();
			//stack.pop();
			temp = temp.next;
		}
		temp.next = null;
		return list;
	}

}
