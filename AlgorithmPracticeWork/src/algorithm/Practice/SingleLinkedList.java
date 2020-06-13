package algorithm.Practice;

public class SingleLinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void insertFront(int element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			newNode.next = null;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertEnd(int element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public Node deleteFront() {
		if (head == null) {
			System.out.println("Linked list is empty");
			return null;
		} else {
			Node temp = head;
			head = head.next;
			return temp;
		}
	}

	public Node deleteEnd() {
		if (head == null) {
			System.out.println("Linkedlist is empty");
			return null;
		} else if (head.next == null) {
			Node temp = head;
			head = null;
			return temp;
		} else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			Node last = temp.next;
			temp.next = null;
			return last;
		}
	}

	public void printNode() {
		if (head == null) {
			System.out.println("LinkedinList is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + "");
			temp = temp.next;
		}

	}

	public static void main(String args[]) {
		SingleLinkedList list = new SingleLinkedList();
		System.out.println("Linlked List : ");
		list.insertFront(12);
		list.insertFront(45);
		list.insertEnd(80);
		list.deleteFront();
		list.deleteEnd();
		list.deleteFront();
		list.deleteFront();
		list.deleteFront();
		list.printNode();

	}
}
