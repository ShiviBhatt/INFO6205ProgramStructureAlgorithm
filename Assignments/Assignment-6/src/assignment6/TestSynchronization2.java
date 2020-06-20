package assignment6;

class Table {
	void printTable(int n) {// synchronized method
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}
}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

public class TestSynchronization2 {

	public static void main(String args[]) {
		Table obj1 = new Table();// only one object
		Table obj2 = new Table();// only one object

		MyThread1 t1 = new MyThread1(obj1);
		MyThread2 t2 = new MyThread2(obj2);
		t1.start();
		t2.start();
	}
}

//This is not synchronized because we are creating 2 different instances of Table, and passing it to 2 different threads.
//These 2 threads are operating on totally different methods, which belong to different class instances

//There are many way to make it synchronized, I will give 2 easiest once
//1. Pass the same Table object to both the threads

//Below is the main method
//public static void main(String args[]) {
//	Table obj = new Table();// only one object
//	
//	MyThread1 t1 = new MyThread1(obj);
//	MyThread2 t2 = new MyThread2(obj);
//	t1.start();
//	t2.start();
//}

//OR 

//2. Make printTable method static

//synchronized static void printTable(int n) {// synchronized method
//	for (int i = 1; i <= 5; i++) {
//		System.out.println(n * i);
//		try {
//			Thread.sleep(400);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//}
