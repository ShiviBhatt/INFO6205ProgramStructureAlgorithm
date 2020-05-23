package assignment2.Work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q5QueueLinkedList {

	Node head;

	static class Node {

		String data;
		Node next;

		Node(String d) {
			data = d;
			next = null;
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

	public static void main(String args[]) {
		ArrayList<String> list = readFile();
		Q5QueueLinkedList queue = new Q5QueueLinkedList();
		System.out.println("------------LINKED LIST IMPLEMENTATION---------------");
		System.out.println("5(1)-------enqueue 3 elements into queue-----------");
		enqueueThreeElements(list, queue);
		System.out.println("5(2)-------dequeue 2 elements from queue-----------");
		dequeueTwoElements(queue);
		System.out.println("5(3)-------enqueue all elements from queue-----------");
		enqueueAllElements(list, queue);
		System.out.println("5(4)-------dequeue all elements from queue-----------");
		dequeueAllElements(queue);
		System.out.println("5(5)-------enqueue all elements from queue-----------");
		enqueueAllElements(list, queue);
		System.out.println("5.6.1-------Print Reverse Order-----------------------");
		printReverseOrder(list, queue);
		System.out.println("5.6.2-------Print Original Order----------------------");
		printOriginalOrder(list, queue);

	}

	public static void enqueueThreeElements(ArrayList<String> list, Q5QueueLinkedList queue) {
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i));
			queue.enqueue(list.get(i));

		}
		System.out.println(" ");
	}

	public static void dequeueTwoElements(Q5QueueLinkedList queue) {
		for (int i = 0; i < 2; i++) {

			String element = queue.dequeue();
			System.out.println(element);
		}
		System.out.println(" ");
	}

	public static void enqueueAllElements(ArrayList<String> list, Q5QueueLinkedList queue) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			queue.enqueue(list.get(i));
		}
		System.out.println(" ");
	}

	public static void dequeueAllElements(Q5QueueLinkedList queue) {
		while (!queue.isEmpty()) {
			String element = queue.dequeue();
			System.out.println(element);
		}
		System.out.println(" ");
	}

	private static void printOriginalOrder(ArrayList<String> list, Q5QueueLinkedList queue) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(" ");
	}

	private static void printReverseOrder(ArrayList<String> list, Q5QueueLinkedList tempQueue) {
		for (int i = list.size(); i > 0; i--) {
			System.out.println(list.get(i - 1));
		}
		System.out.println(" ");

	}

}
