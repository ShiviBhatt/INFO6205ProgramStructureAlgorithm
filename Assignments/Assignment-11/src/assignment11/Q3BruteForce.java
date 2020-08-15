package assignment11;

public class Q3BruteForce {
	public static int search(String text, String pattern) {

		int lengthOfText = text.length();
		int lengthOfPattern = pattern.length();

		for (int i = 0; i <= lengthOfText - lengthOfPattern; i++) {

			int j;

			for (j = 0; j < lengthOfPattern; j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}

			if (j == lengthOfPattern)
				return i;
		}

		return lengthOfText;
	}

	public static void main(String[] args) {
		System.out.println("Pattern found in text at position = " + search("ABCADCBABABCDABCD", "BCD"));
	}

}
