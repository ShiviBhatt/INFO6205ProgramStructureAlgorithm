package Assignment1Work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q8StackArray {
	
	String[] stack;
	int top = -1;
	int size =100;
	
	Q8StackArray() {
		stack = new String[100];
	}
	
	void push(String val) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		stack[++top] = val;
	}
	
	String pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return stack[top--];
		
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	boolean isFull() {
		return top == stack.length -1;
	}
	
	String peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return stack[top];
	}
	
	public static void main(String args[]) {
		ArrayList<String> list = readFile();
		Q8StackArray q8StackArray = new Q8StackArray();
		System.out.println("-------1. pushFiveElements-------");
		pushFiveElements(list, q8StackArray);
		System.out.println("-------2. popFourElements-------");
		popFourElements(q8StackArray);
		System.out.println("-------3. pushAllElements-------");
		pushAllElements(list, q8StackArray);
		System.out.println("-------4. popAllElements-------");
		popAllElements(q8StackArray);
		System.out.println("-------5. pushAllElements-------");
		pushAllElements(list, q8StackArray);
		System.out.println("-------6.1 Reverse order-------");
		printReverseOrder(q8StackArray);
		System.out.println("-------6.2 Original order-------");
		printOriginalOrder(q8StackArray);
		
	}
	
	
	private static void printOriginalOrder(Q8StackArray stack) {
		System.out.println("Original order");
		Q8StackArray tempStack = new Q8StackArray();
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

	private static void printReverseOrder(Q8StackArray stack) {
		System.out.println("Reverse order");
		Q8StackArray tempStack = new Q8StackArray();
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

	private static void popAllElements(Q8StackArray stack) {
		while(!stack.isEmpty()) {
			String val = stack.pop();
			System.out.println(val);
		}	
		System.out.println(" ");
	}

	private static void pushAllElements(ArrayList<String> list, Q8StackArray stack) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			stack.push(list.get(i));
		}
		System.out.println(" ");
	}

	private static void popFourElements(Q8StackArray stack) {
		for(int i = 0; i < 4; i++) {
			String val = stack.pop();
			System.out.println(val);
		}
		System.out.println(" ");
	}

	private static void pushFiveElements(ArrayList<String> list, Q8StackArray stack) {
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
