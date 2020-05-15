package Assignment1Work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q8StackLinkedList {
	
	static class Node{
		String val;
		Node next;
	}
	
	Node top = null;
	
	void push(String val) {
		Node curNode = new Node();
		curNode.val = val;
		if(top == null) {
			top = curNode;
		}else {
			curNode.next = top;
			top = curNode;
		}
	}
	
	String pop() {
		if(!isEmpty()) {
			Node curNode = top;
			top = top.next;
			curNode.next = null;
			return curNode.val;
		}
		System.out.println("Stack is Empty");
		return null;
	}
	
	
	String peek() {
		if(!isEmpty()) {
			return top.val;
		}
		System.out.println("Stack is Empty");
		return null;
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	
	public static void main(String args[]) {
		ArrayList<String> list = readFile();
		Q8StackLinkedList q8StackLinkedList = new Q8StackLinkedList();
		System.out.println("-------1. pushFiveElements-------");
		pushFiveElements(list, q8StackLinkedList);
		System.out.println("-------2. popFourElements-------");
		popFourElements(q8StackLinkedList);
		System.out.println("-------3. pushAllElements-------");
		pushAllElements(list, q8StackLinkedList);
		System.out.println("-------4. popAllElements-------");
		popAllElements(q8StackLinkedList);
		System.out.println("-------5. pushAllElements-------");
		pushAllElements(list, q8StackLinkedList);
		System.out.println("-------6.1 Reverse order-------");
		printReverseOrder(q8StackLinkedList);
		System.out.println("-------6.2 Original order-------");
		printOriginalOrder(q8StackLinkedList);
		
	}
	
	
	private static void printOriginalOrder(Q8StackLinkedList stack) {
		System.out.println("Original order");
		Q8StackLinkedList tempStack = new Q8StackLinkedList();
		while(!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}
		while(!tempStack.isEmpty()) {
			String val = tempStack.pop();
			System.out.println(val);
			stack.push(val);
		}	
		System.out.println(" ");
	}

	private static void printReverseOrder(Q8StackLinkedList stack) {
		System.out.println("Reverse order");
		Q8StackLinkedList tempStack = new Q8StackLinkedList();
		while(!stack.isEmpty()) {
			String val = stack.pop();
			System.out.println(val);
			tempStack.push(val);
		}
		
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		System.out.println(" ");
	}

	private static void popAllElements(Q8StackLinkedList stack) {
		while(!stack.isEmpty()) {
			String val = stack.pop();
			System.out.println(val);
		}	
		System.out.println(" ");
	}

	private static void pushAllElements(ArrayList<String> list, Q8StackLinkedList stack) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			stack.push(list.get(i));
		}
		System.out.println(" ");
	}

	private static void popFourElements(Q8StackLinkedList stack) {
		for(int i = 0; i < 4; i++) {
			String val = stack.pop();
			System.out.println(val);
		}
		System.out.println(" ");
	}

	private static void pushFiveElements(ArrayList<String> list, Q8StackLinkedList stack) {
		for(int i = 0; i < 5; i++) {
			System.out.println(list.get(i));
			stack.push(list.get(i));
		}
		System.out.println(" ");
	}

	public static ArrayList <String> readFile() {
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

}
