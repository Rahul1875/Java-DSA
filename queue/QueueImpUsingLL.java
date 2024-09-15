package src.com.pack.queue;

class Node {
	int data;
	Node next;
	public Node(int k) {
		data = k;
		next= null;
	}
	
}

public class QueueImpUsingLL {

	Node head,tail;
	
	public static void main(String[] args) {
		
		QueueImpUsingLL queue = new QueueImpUsingLL();
		queue.insert(5);
		queue.delete();
		queue.delete();
		queue.delete();
		queue.insert(5);
		queue.insert(8);
		
		queue.display();
		

	}

	private void display() {
		
		Node temp = head;		
		if(temp ==null) {
			return;
		}
		
		while(temp != tail) {
			System.out.print("->"+temp.data);
			temp = temp.next;
		}
		System.out.println("->"+tail.data);
	}

	private void insert(int k) {
		
		Node new_node = new Node(k);
		
		if(head==null && tail ==null) {
			head = new_node;
			tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
		
	}

	private void delete() {
		
		if(head == null) {
			head = tail = null;
		} else {
			head = head.next;
		}
		
	}

}
