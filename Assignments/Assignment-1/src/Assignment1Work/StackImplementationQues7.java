package Assignment1Work;

import java.util.Arrays;


public class StackImplementationQues7<E>  {
	int size;
	String arr[];
	int top;
 
	StackImplementationQues7(int size) {
		this.size = size;
		this.arr = new String[size];
		this.top = -1;
	}
 
	public void push(String pushedElement) {
		if (!isFull()) {
			top++;
			arr[top] = pushedElement;
			System.out.println("Pushed element:" + pushedElement);
		} else {
			System.out.println("Stack is full !");
		}
	}
 
	public String pop() {
		if (!isEmpty()) {
			int returnedTop = top;
			top--;
			System.out.println("Popped element :" + arr[returnedTop]);
			return arr[returnedTop];
 
		} else {
			System.out.println("Stack is empty !");
			return null;
		}
	}
 
	public String peek() {
		if(!this.isEmpty())
                        return arr[top];
                else
                {
                        System.out.println("Stack is Empty");
                        return null;
                }
	}
 
	public boolean isEmpty() {
		return (top == -1);
	}
 
	public boolean isFull() {
		return (size - 1 == top);
	}
 
	public static void main(String[] args) {
		StackImplementationQues7 StackCustom = new StackImplementationQues7(10);
		StackCustom.pop();
		System.out.println("=================");
		StackCustom.push("It");
		StackCustom.push("was");
		StackCustom.push("the");
		StackCustom.push("best");
		StackCustom.push("of");
		StackCustom.push("time");
		System.out.println("=================");
		StackCustom.pop();
		StackCustom.pop();
		StackCustom.pop();
		System.out.println("=================");
	}
}
