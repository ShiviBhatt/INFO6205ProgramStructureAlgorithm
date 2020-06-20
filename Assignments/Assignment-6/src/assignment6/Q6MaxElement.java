// Shivi Bhatt
// NUID: 001027605
package assignment6;

public class Q6MaxElement {

	public static void main(String[] args) {

		Q6BinaryTree bst = new Q6BinaryTree();
		char[] arr1 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
		System.out.println("Question : 6 \n");
		for (char arrayValue : arr1) {
			System.out.println("Elements Inserted are " + arrayValue);
			bst.root = bst.insertElement(bst.root, arrayValue);
		}

		char maximum = (char) bst.maximumElement(bst.root);
		System.out.println("Max element :" + maximum);
	}

}
