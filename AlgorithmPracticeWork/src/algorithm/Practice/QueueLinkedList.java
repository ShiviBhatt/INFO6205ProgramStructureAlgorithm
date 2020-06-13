package algorithm.Practice;

public class QueueLinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void enqueue(int element) {

		Node newNode = new Node(element);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}

	}

	public Node dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
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

	public boolean isEmpty() {

		return (head == null);

	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + "");
			temp = temp.next;
		}

	}

	public static void main(String args[]) {
		QueueLinkedList list = new QueueLinkedList();
		System.out.println("Linlked List : ");
		list.enqueue(10);
		list.enqueue(20);
		list.enqueue(40);
		list.enqueue(50);
		list.dequeue();

		list.printQueue();

	}
}
