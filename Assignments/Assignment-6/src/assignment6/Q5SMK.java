// Shivi Bhatt
// NUID: 001027605
package assignment6;

public class Q5SMK {

	public static void main(String[] args) {

		int[] arr = { 9, 23, 45, 1, 5, 14, 55, 24, 13, 11, 8, 19, 4, 31, 35, 56 };
		Two_Three_Tree Two_Three_Tree = new Two_Three_Tree();
		Tree234 theT = new Tree234();
		Q5BinaryTree binaryTree = new Q5BinaryTree();
		System.out.println("\n Binary Tree ");
		for (int arrayValue : arr) {
			binaryTree.root = binaryTree.insertElement(binaryTree.root, arrayValue);
			System.out.println("Inserted Elements " + arrayValue);
			theT.insert(arrayValue);
			Two_Three_Tree.insert(arrayValue);
		}
		System.out.println("\nTwo three tree (2-3) ");
		Two_Three_Tree.bfsList();
		Boolean searchResult = Two_Three_Tree.search(1);
		System.out.println("Searching for 1 " + searchResult);
		System.out.println("\nTwo three Four tree (2-3-4) ");
		theT.displayTree();
	}

}
