package algorithm.Practice;

public class QueueArray {

	public static final int SIZE = 100;
	int arr[];
	int count = -1;

	QueueArray() {
		arr = new int[SIZE];
	}

	public void enqueue(int data) {
		if (count == arr.length - 1) {
			System.out.println("Queue is Full");
		} else {
			count++;
			arr[count] = data;
		}
	}

	public int dequeue() {
		if (count == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int temp = arr[0];
		for (int i = 0; i < count; i++) {
			arr[i] = arr[i + 1];
		}
		count--;
		return temp;
	}

	public void printQueue() {
		for (int i = 0; i <= count; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	public static void main(String args[]) {
		QueueArray queue = new QueueArray();

		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(90);
		queue.enqueue(70);
		queue.dequeue();
		queue.printQueue();

	}
}
