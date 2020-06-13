package algorithm.Practice;

import java.util.Scanner;

public class StackArrayImpl {
	
	int arr[];
	int top = -1;
	static int size =100;

	
	public StackArrayImpl(int size) {
		arr = new  int[size]; 
	}
	
	public void push (int item) {
		if(isFull()) {
			System.out.println("STACK IS FULL");
		}else {
			arr[++top] = item;
			System.out.println("Element added : " + arr[top]);
		}
	}
	
	int pop() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY");
			return -1;
		}
			return arr[top--];	
		

	}
	
	int peek() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY");
			return -1;
		}
		return arr[top];
		
	}
	public void display() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY INSERT ELEMENT");
		}else
		{
			for(int i=0;i< arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
	}
	
	boolean isFull() {
		return (size -1 == top);
	}
	
	boolean isEmpty() {
		return (top == -1);
	}
	
	public static void main(String args[]) {
		StackArrayImpl stack = new StackArrayImpl(size);
		Scanner input = new Scanner(System.in);
		System.out.println("-------Welcome Stack Array Implementation-----------");
		System.out.println("\n 1 . Push ");
		System.out.println("\n 2.  Pop   ");
		System.out.println("\n 3.  Peek");
		System.out.println("\n 4.  Display Stack");
		System.out.println("\n 5.  Exit");
		boolean x = true;
		
	    int i = input.nextInt();
		
		while(x) {
			switch(i) {
			case 1:
				System.out.println("Enter Element to be added\n");
				int data =input.nextInt();
				stack.push(data);
				break;
			case 2:
				stack.pop();
				break;
			case 3: 
				stack.peek();
				break;
			case 4: 
				stack.display();
				break;
			case 5:
				 x = false;
				break;
			 default:
                 System.out.println("PRESS 1 , 2, 3, 4 or 5 FROM THE OPTIONS");
			}
			
		}
		input.close();
	}

}
