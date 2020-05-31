package algorithm.Practice;

public class Q7HashCodeString {
	int hash;

	public int hashCode(String value) {
		int h = hash;
		if (h == 0 && value.length() > 0) {
			char val[] = value.toCharArray();

			for (int i = 0; i < value.length(); i++) {
				h = 31 * h + val[i];
			}
			hash = h;
		}
		return h;
	}

	public static void main(String[] args) {
		Q7HashCodeString h = new Q7HashCodeString();
		String str = "Welcome Students to Class";
		System.out.println("Hashcode for String \"Welcome Class\" is " + h.hashCode(str)); // -2097290371

	}

}
