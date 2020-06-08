
public class Q3CountBinary {

	public static int countStringBinary(int n, int l) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return (l == 1) ? 1 : 2;
		}
		if (l == 0) {
			return countStringBinary(n - 1, 0) + countStringBinary(n - 1, 1);
		} else {
			return countStringBinary(n - 1, 0);
		}
	}

	/* Driver program to test above function */
	public static void main(String args[]) {

		int res = countStringBinary(4, 0);
		System.out.println("The result is =" + " " + res);

	}
}
