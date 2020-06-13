package algorithm.Practice;

public class Q4QueueArray {
	public static final int SIZE = 100;
	String arr[];
	int count = -1;

	Q4QueueArray() {
		arr = new String[SIZE];
	}

	public void enqueue(String element) {
		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			count++;
			arr[count] = element;
		}
	}

	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		} else {
			String temp = arr[0];
			for (int i = 0; i < count; i++) {
				arr[i] = arr[i + 1];
			}
			count--;
			return temp;
		}
	}

	public boolean isEmpty() {
		return (count == -1);
	}

	public boolean isFull() {
		return (count == arr.length - 1);
	}

	public void printQueue() {
		for (int i = 0; i <= count; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	public static void main(String args[]) {
		Q4QueueArray queue = new Q4QueueArray();
		queue.enqueue("It");
		queue.enqueue("was");
		queue.enqueue("the");
		queue.enqueue("best");
		queue.enqueue("of");
		queue.enqueue("times");
		queue.printQueue();
		System.out.println("After dequeue");
		queue.dequeue();
		queue.printQueue();

	}

}
