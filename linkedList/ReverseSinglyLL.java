package src.com.pack.llist;

public class ReverseSinglyLL {

	Node head;

	public static void main(String[] args) {

		ReverseSinglyLL list = new ReverseSinglyLL();
		list = insert(list, 5);
		list = insert(list, 1);
		list = insert(list, 3);
		list = insert(list, 7);
		list = insert(list, 9);
		list = insert(list, 15);
		System.out.println("LIST ELEMENT:");
		printList(list);

		// Recursive Method
		
		System.out.println("REVERSE LIST BY RECURSION METHOD");
		reverseListByRecursion(list.head);
		System.out.println();
		
		// Iterative Method

		 System.out.println("REVERSE LIST BY ITERATIVE METHOD"); 
		 list.head = reverseListByIterative(list); 
		 printList(list);
	}

	private static void reverseListByRecursion(Node head) {

		Node curr = head;
		if (curr == null) {
			return;
		}
		reverseListByRecursion(curr.next);
		System.out.print("->" + curr.data);
	}

	private static Node reverseListByIterative(ReverseSinglyLL list) {

		Node curr = list.head;
		Node prev, next;
		prev = next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void printList(ReverseSinglyLL list) {

		Node curr = list.head;
		while (curr != null) {
			System.out.print("->" + curr.data);
			curr = curr.next;
		}
		System.out.println();
	}

	private static ReverseSinglyLL insert(ReverseSinglyLL list, int key) {

		Node new_node = new Node(key);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node curr = list.head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new_node;
		}

		return list;
	}

}
