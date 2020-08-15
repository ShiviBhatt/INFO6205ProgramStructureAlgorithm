package assignment11;

import java.util.Arrays;

public class GreedyAlgorithm_A {
	public static void main(String[] args) {
		int[] A = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int T = 15;
		System.out.println("Number Of things completed in time T : " + GreedyAlgo(A, T));
	}

	public static int GreedyAlgo(int[] A, int T) {
		int N = A.length, current = 0, numberOfThings = 0;
		Arrays.sort(A);
		for (int i = 0; i < N; i++) {
			current += A[i];
			if (current > T)
				break;
			numberOfThings++;
		}
		return numberOfThings;
	}
}
