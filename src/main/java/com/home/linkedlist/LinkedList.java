package com.home.linkedlist;

public class LinkedList {
	public Node start;
	private Node end;
	
	void insertBeginning(int info) {
		if (start == null) {
			start = new Node();
			start.info = info;
			end = start;
		}
		else {
			Node n = new Node();
			n.info = info;
			n.next = start;
			start = n;
		}
		
	}
	
	void insertEnd(int info) {
		Node n = new Node();
		n.info = info;
		if (end == null) {
			end = new Node();
			end.info = info;
			start = end;
		}
		else {
			n.next = null;
			end.next = n;
			end = n;
		}
	}
	
	void insertMiddle(int search, int info) {
		Node n = new Node();
		n.info = info;
		Node trav = start;
		if (start == null) {
			insertBeginning(info);
		}
		else {
			while(trav.next != null) {
				if (trav.info == search) {
					n.next = trav.next;
					trav.next = n;	
					break;
				}
				else {
					trav = trav.next;
				}
			}
		}
	}
	
	void deleteBeginning() {
		if (start == null) {
			return;
		}
		else {
			if (start == end) {
				start = end = null;
			}
			else {
				start = start.next;
			}
		}
	}
	
	void deleteEnd() {
		if (end == null) {
			return;
		}
		else {
			if (start == end) {
				start = end = null;
			}
			else {
				Node trav = start;
				while (trav.next != end) {
					trav = trav.next;
				}
				end = trav;
				trav.next = null;
			}
		}
	}
	
	void deleteMiddle(int info) {
		if (start == null) {
			return;
		}
		else {
			if (start == end) {
				if (start.info == info) {
					start = end = null;
				}
				else {
					System.out.println("item not found.");
					return;
				}
			}
			else {
				Node trav = start;
				Node prev = null;
				while (trav.next != null) {
					if (trav.info == info) {
						prev.next = trav.next;
						break;
					}
					else {
						prev = trav;
						trav = trav.next;
					}
				}
			}
		}
	}
	
	void print(Node root) {
		Node trav = root;
		while (trav != null) {
			System.out.print(trav.info + " ");
			trav = trav.next;
		}
	}
	
	public void reverseLinkedList() {
		Node trav = start;
		Node prev = null;
		while(trav != null) {
			Node temp = trav.next;
			trav.next = prev;
			prev = trav;
			trav = temp;
		}
		start = prev;
	}

	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.insertBeginning(7);
		lList.insertBeginning(6);
		lList.insertBeginning(5);
		lList.print(lList.start);
		System.out.println("\n------------------------");
		lList.insertEnd(4);
		lList.print(lList.start);
		System.out.println("\n------------------------");
		lList.insertMiddle(6, 9);
		lList.print(lList.start);
		System.out.println("\n------------------------");
		lList.deleteBeginning();
		lList.print(lList.start);
//		System.out.println("\n------------------------");
//		lList.deleteEnd();
//		lList.print(lList.start);
		System.out.println("\n------------------------");
//		lList.deleteMiddle(9);
		lList.reverseLinkedList();
		lList.print(lList.start);
	}

}
