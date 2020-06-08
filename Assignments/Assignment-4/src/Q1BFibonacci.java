

import java.util.Scanner;

public class Q1BFibonacci {

	// Iteration method
	static int fibIteration(int n) {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}
		return x;
	}

	// Recursive method
	static int fibRecursion(int n) {
		if ((n == 1) || (n == 0)) {
			return n;
		}
		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// nth element input
		System.out.print("Enter the last element of Fibonacci sequence: ");
		int n = sc.nextInt();

		// Print out iteration method
		System.out.println("Fibonacci iteration:");
		long start = System.currentTimeMillis();
		System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibIteration(n));
		System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);

		// Print out recursive method
		System.out.println("Fibonacci recursion:");
		start = System.currentTimeMillis();
		System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibRecursion(n));
		System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);
	}

}
