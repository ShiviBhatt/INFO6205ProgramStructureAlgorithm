package algorithm.Practice;

public class Q3CircularQueue {

	int front = -1;
	int rear = -1;
	int size;
	int[] arr;

	Q3CircularQueue(int[] arr, int size) {
		this.size = size;
		arr = new int[size];
		this.arr = arr;
	}

	public boolean IsEmpty() {
		return rear == -1 && front == -1;
	}

	public boolean Isfull() {
		return (rear + 1) % size == front;
	}

	public void enqueue(int data) {
		// condition if queue is full
		if (Isfull()) {
			System.out.println(" Queue is Full\n");
		}
		// condition for empty queue
		if (IsEmpty()) {
			front = 0;
			rear = 0;
			arr[rear] = data;
		} else {
			// next position of rear
			rear = (rear + 1) % size;
			arr[rear] = data;
		}
	}

	public void dequeue() {

		// condition for only one element
		if (front == rear && !IsEmpty()) {
			int temp = arr[front];
			front = -1;
			rear = -1;
			System.out.println("Dequeued element " + temp);
		}
		// codition for empty queue
		if (IsEmpty()) {
			System.out.println("Queue is empty");
		} else {
			int temp = arr[front];
			front = (front + 1) % size;
			System.out.println("Dequeued element " + temp);
		}
	}

	public void display() {
		if (front == -1) {
			System.out.println("Queue is Empty ");
		}
		if (rear >= front) {
			System.out.println("Elements in the circular queue are:");
			for (int i = front; i <= rear; i++) {
				System.out.print(arr[i] + "," + "\n");
			}
		} else {
			System.out.println("Elements in the circular queue are:");
			for (int i = front; i < size; i++) {
				System.out.print(arr[i] + "," + "\n");
			}
			for (int i = 0; i <= rear; i++) {
				System.out.print(arr[i] + "," + "\n");
			}
		}
		if (Isfull()) {
			System.out.println("Queue is Full");
		}
	}

	public static void main(String[] args) {

		int arr[] = {};
		Q3CircularQueue cq = new Q3CircularQueue(arr, 10);
		cq.enqueue(12);
		cq.enqueue(17);
		cq.enqueue(38);
		cq.enqueue(3);
		cq.enqueue(9);
		cq.enqueue(82);
		cq.enqueue(10);
		cq.enqueue(31);
		cq.enqueue(24);
		cq.enqueue(31);
		cq.display();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		System.out.println("\n After dequeuing 3 elements");
		cq.display();
		cq.enqueue(12);
		cq.enqueue(17);
		System.out.println("\n After enqueuing 2 elements");
		cq.display();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
//		cq.dequeue();
//		cq.dequeue();
//		cq.dequeue();
//		cq.dequeue();
//		cq.dequeue();
//		cq.dequeue();

	}
}
