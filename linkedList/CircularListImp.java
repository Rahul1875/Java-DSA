package com.pack.llist;

class CNode{

	int data;
	CNode next;
	public CNode(int k) {
		data = k;
		next = null;
	} 
	
}

public class CircularListImp {

	CNode head, tail;
	public static void main(String[] args) {
		
		CircularListImp clist = new CircularListImp();
		clist = insert(clist,5);
		clist = insert(clist,1);
		clist = insert(clist,3);
		clist = insert(clist,7);
		clist = insert(clist,9);
		clist = insert(clist,15);
		printClist(clist);
		
		clist = insertAthead(clist,11);
		printClist(clist);
		
		clist = deleteAtEnd(clist);
		printClist(clist);
		
		clist = deleteAtHead(clist);
		printClist(clist);
		
	}
	private static CircularListImp deleteAtHead(CircularListImp clist) {
		
		clist.head = clist.head.next;
		clist.tail.next = clist.head;
		
		return clist;
	}
	
	private static CircularListImp deleteAtEnd(CircularListImp clist) {
		
		CNode curr = clist.head;
		while(curr.next!=clist.tail) {
			curr=curr.next;
		}
		clist.tail = curr;
		curr.next = clist.head;
		
		return clist;
	}
	private static CircularListImp insertAthead(CircularListImp clist, int key) {
		
		CNode new_node = new CNode(key);
		clist.tail.next = new_node;
		new_node.next = clist.head;
		clist.head = new_node;
		
		return clist;
	}
	private static void printClist(CircularListImp clist) {
		
		CNode curr = clist.head;
		while(curr!=clist.tail) {
			System.out.print("->"+curr.data);
			curr = curr.next;
		}
		System.out.println("->"+clist.tail.data);
	}
	
	
	private static CircularListImp insert(CircularListImp clist, int key) {
	
		CNode new_node = new CNode(key);
		
		if(clist.head ==null && clist.tail ==null) {
			clist.head = clist.tail = new_node;
		} else {
			clist.tail.next = new_node;
			new_node.next = clist.head;
			clist.tail = clist.tail.next;
		}
		
		return clist;
	}

}
