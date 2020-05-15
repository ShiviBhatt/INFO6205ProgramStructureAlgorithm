package Assignment1Work;

public class Q7Stack {
	
	String[] stack;
	int top = -1;
	
	Q7Stack(int size) {
		stack = new String[size];
	}
	
	void push(String val) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		top = top + 1;
		stack[top] = val;
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
		String input = "It was the best of time";
		String[] arr = input.split(" ");
		Q7Stack q7Stack = new Q7Stack(arr.length);
		
		for(int i= arr.length - 1; i >= 0; i--) {
			q7Stack.push(arr[i]);
		}
		
		while(!q7Stack.isEmpty()) {
			System.out.print(q7Stack.pop() + (q7Stack.isEmpty() ? "" : " "));
		}
		
	}
	
}
