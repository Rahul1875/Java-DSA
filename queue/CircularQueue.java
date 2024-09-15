package src.com.pack.queue;

public class CircularQueue {

	final int MAX_SIZE = 100;
	int front = 0;
	int rear = 0;
	int[] arr = new int[MAX_SIZE];
	
	public static void main(String[] args) {
		
		CircularQueue queue = new CircularQueue();
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
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
		
		if((rear+1)%MAX_SIZE == front) {
			System.out.println("Queue Overflow");
			return;
		} else if(front ==-1 && rear ==-1) {
			front =0;
			rear =0;
		}else if(rear == MAX_SIZE-1 && front != 0){  
	        rear = 0;  
	    }else {
			rear++;
		}
		arr[rear] = data;
	}

	private void dequeue() {
		
		 if(front == -1 && rear ==-1) {
			System.out.println("Queue is Empty");
			return;
		} else if(front == rear){  
	            front = -1;  
	            rear = -1 ;  
	    }else if(front == MAX_SIZE-1){
	    	front=0;
	    }else{  
	            front = front + 1;  
	    }  			
	}
		
}

