package com.pack.llist;

class DNode{
	int data;
	DNode next, prev;
	
	public DNode(int key) {
		data =key;
		next= prev =null;
	}
}

public class DoublyListImp {

	DNode head;
	
	public static void main(String[] args) {
		
		DoublyListImp dlist = new DoublyListImp();
		dlist = insert(dlist,5);
		dlist = insert(dlist,1);
		dlist = insert(dlist,3);
		dlist = insert(dlist,7);
		dlist = insert(dlist,8);
		dlist = insert(dlist,15);
		printList(dlist);
		
		System.out.println();
		dlist = insertAtHead(dlist,11);
		printList(dlist);
		
		System.out.println();
		dlist = delete(dlist,7);
		printList(dlist);
		
		System.out.println();
		dlist = deleteByHead(dlist);
		printList(dlist);
	}

	private static DoublyListImp deleteByHead(DoublyListImp dlist) {
		
		dlist.head = dlist.head.next;
		return dlist;
	}

	private static DoublyListImp delete(DoublyListImp dlist, int k) {
		
		DNode curr = dlist.head;
		while(curr.data!=k) {
			curr= curr.next;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		
		
		return dlist;
	}

	private static DoublyListImp insertAtHead(DoublyListImp dlist, int k) {
		
		DNode new_node = new DNode(k);
		new_node.next = dlist.head;
		dlist.head.prev = new_node;
		dlist.head = new_node;
		
		return dlist;
	}

	private static void printList(DoublyListImp dlist) {
		DNode curr = dlist.head;
		while(curr!=null) {
			System.out.print("->"+curr.data);
			curr = curr.next;
		}
		
	}

	private static DoublyListImp insert(DoublyListImp dlist, int k) {
		
		DNode new_node = new DNode(k);
		
		DNode curr = dlist.head;
		if(dlist.head ==null) {
			dlist.head = new_node;	
		} else {
			while(curr.next!=null) {
				curr = curr.next;
			}
			curr.next = new_node;
			new_node.prev = curr;
		}
		return dlist;
	}

}
