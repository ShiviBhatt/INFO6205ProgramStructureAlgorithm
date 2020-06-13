package algorithm.Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q5QueueArray {

	public static final int SIZE = 100;
	String arr[];
	int count = -1;

	Q5QueueArray() {
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

	public static ArrayList<String> readFile() {
		Scanner sc = null;
		ArrayList<String> List = new ArrayList<String>();
		try {
			sc = new Scanner(new File("./input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("unable to read file");
			return List;
		}

		while (sc.hasNext()) {
			List.add(sc.next());
		}
		sc.close();
		return List;
	}

	public static void enqueueThreeElements(ArrayList<String> list, Q5QueueArray queue) {
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i));
			queue.enqueue(list.get(i));

		}
		System.out.println(" ");
	}

	public static void dequeueTwoElements(Q5QueueArray queue) {
		for (int i = 0; i < 2; i++) {
			String element = queue.dequeue();
			System.out.println(element);
		}
		System.out.println(" ");
	}

	public static void enqueueAllElements(ArrayList<String> list, Q5QueueArray queue) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			queue.enqueue(list.get(i));
		}
		System.out.println(" ");
	}

	public static void dequeueAllElements(Q5QueueArray queue) {
		while (!queue.isEmpty()) {
			String element = queue.dequeue();
			System.out.println(element);
		}
		System.out.println(" ");
	}

	private static void printOriginalOrder(ArrayList<String> list, Q5QueueArray queue) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(" ");
	}

	private static void printReverseOrder(ArrayList<String> list, Q5QueueArray queue) {
		for (int i = list.size(); i > 0; i--) {
			System.out.println(list.get(i - 1));
		}
		System.out.println(" ");
	}

	public static void main(String args[]) {
		ArrayList<String> list = readFile();
		Q5QueueArray queue = new Q5QueueArray();
		System.out.println("------------ARRAY IMPLEMENTATION---------------");
		System.out.println("-------enqueue 3 elements into queue-----------");
		enqueueThreeElements(list, queue);
		System.out.println("-------dequeue 2 elements from queue-----------");
		dequeueTwoElements(queue);
		System.out.println("-------enqueue all elements from queue-----------");
		enqueueAllElements(list, queue);
		System.out.println("-------dequeue all elements from queue-----------");
		dequeueAllElements(queue);
		System.out.println("-------enqueue all elements from queue-----------");
		enqueueAllElements(list, queue);
		System.out.println("-------Print Reverse Order-----------------------");
		printReverseOrder(list, queue);
		System.out.println("-------Print Original Order----------------------");
		printOriginalOrder(list, queue);

	}

}
