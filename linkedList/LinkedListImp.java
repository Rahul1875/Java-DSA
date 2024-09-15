package src.com.pack.llist;

class Node{
	int data;
	Node next;
	public Node(int key) {
		data = key;
		next = null;
	}
}

public class LinkedListImp {

	Node head;
	
	public static void main(String[] args) {
	
		LinkedListImp list = new LinkedListImp();
	
		list = insert(list, 5);
		list = insert(list, 1);
		list = insert(list, 3);
		list = insert(list, 7);
		list = insert(list, 9);
		list = insert(list, 15);
		printList(list);
		
		System.out.println();
		// insert at middle position by position
		list = insertByPosition(list, 6 , 3);
		printList(list);
		
		System.out.println();
		// insert at middle position by node 
		list = insertByNodeValue(list, 10, 6);
		printList(list);
		
		System.out.println();
		list = deleteNode(list, 7);
		printList(list);
		
	}

	private static LinkedListImp deleteNode(LinkedListImp list, int key) {
		
		Node curr = list.head;
		Node prev= null;
		while(curr.data != key) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		return list;
	}

	private static LinkedListImp insertByNodeValue(LinkedListImp list, int key, int oldNode) {
		
		Node new_node = new Node(key);
		new_node.next = null;
		Node curr = list.head;
		
		while(curr.data != oldNode) {
			curr = curr.next;
		}
		new_node.next = curr.next;
		curr.next = new_node;
		
		return list;
	}

	private static LinkedListImp insertByPosition(LinkedListImp list, int key, int position) {
		
		Node new_node = new Node(key);
		new_node.next = null;
		Node curr = list.head;
		int var =1;
		while(var < position) {
			var++;
			curr = curr.next;
		}
		new_node.next = curr.next;
		curr.next = new_node;
		
		return list;
	}

	private static void printList(LinkedListImp list) {
		
		Node curr = list.head;
		while(curr!=null) {
			System.out.print("->"+curr.data);
			curr = curr.next;
		}
		
	}

	private static LinkedListImp insert(LinkedListImp list, int key) {
		
		Node new_node = new Node(key);
		new_node.next = null;
		
		if(list.head == null) {
			list.head = new_node;
		}else {
			Node curr = list.head;
			while(curr.next!=null) {
				curr = curr.next;
			}
			curr.next = new_node;
		}
		
		return list;
	}

}
