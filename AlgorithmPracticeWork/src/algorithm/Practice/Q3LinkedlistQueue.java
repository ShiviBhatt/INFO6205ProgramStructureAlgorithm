package algorithm.Practice;

public class Q3LinkedlistQueue {
	Node head;

	static class Node {

		String data;
		Node next;

		Node(String d) {
			data = d;
			next = null;
		}

		public void displayData() {
			System.out.println(data);
		}
	}

	public void enqueue(String element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else if (head.next == null) {
			Node temp = head;
			head = null;
			return temp.data;
		} else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			Node last = temp.next;
			temp.next = null;
			return last.data;
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void printQueue() {
		Node current = head;
		// loop till last node
		while (current != null) {
			current.displayData();
			current = current.next;
		}

	}

	public static void main(String args[]) {
		Q3LinkedlistQueue queue = new Q3LinkedlistQueue();
		System.out.println("LinkedList Queue Implementation : ");
		queue.enqueue("It");
		queue.enqueue("was");
		queue.enqueue("best");
		queue.enqueue("of");
		queue.enqueue("times");
		queue.printQueue();
		System.out.println("\n" + "After dequeue");
		queue.dequeue();
		queue.printQueue();

	}

}
