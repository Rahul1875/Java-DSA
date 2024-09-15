package src.com.pack.queue;

public class QueueImp {

	final int MAX_SIZE = 100;
	int front = -1;
	int rear = -1;
	int[] arr = new int[MAX_SIZE];
	
	public static void main(String[] args) {
		
		QueueImp queue = new QueueImp();
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(7);
		queue.enqueue(8);
		queue.display();
	}

	private void display() {
		if (front == rear) { 
			System.out.println("\nQueue is Empty\n"); 
            return; 
        } 
		System.out.println("Queue Element:");
        // traverse front to rear and print elements 
        for (int i = front; i <=rear; i++) { 
        	System.out.print("->"+arr[i]); 
        } 
	}

	private void enqueue(int data) {
		
		if(rear==MAX_SIZE-1) {
			System.out.println("Queue Overflow");
			return;
		} else if(front ==-1 && rear ==-1) {
			front =0;
			rear =0;
		}else {
			rear++;
		}
		arr[rear] = data;
	}

	private void dequeue() {
		
		 if((front == -1) || front > rear) {
			System.out.println("Queue is Empty");
			return;
		} else if(front == rear){  
	            front = -1;  
	            rear = -1 ;  
	    }else{  
	            front = front + 1;  
	        }  			
	}
		
}
