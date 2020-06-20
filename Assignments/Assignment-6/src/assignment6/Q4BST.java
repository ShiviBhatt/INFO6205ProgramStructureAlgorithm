// Shivi Bhatt
// NUID: 001027605
package assignment6;

public class Q4BST {

	Node root;

	class Node {

		int value;
		Node left;
		Node right;

		public Node(int paramData) {
			value = paramData;
		}
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	static int findMax(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.value;
		int lres = findMax(node.left);
		int rres = findMax(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	int minvalue(Node node) {
		Node current = node;

		while (current.left != null) {
			current = current.left;
		}
		return (current.value);
	}

	void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	Node deleteRec(Node root, int key) {

		if (root == null)
			return root;

		if (key < root.value)
			root.left = deleteRec(root.left, key);
		else if (key > root.value)
			root.right = deleteRec(root.right, key);

		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.value = minvalue(root.right);
			root.right = deleteRec(root.right, root.value);
		}

		return root;
	}

	public static void main(String args[]) {

		Q4BST bt = new Q4BST();
		int arr[] = { 9, 23, 45, 1, 5, 14, 55, 24, 13, 11, 8, 19, 4, 31, 35, 56 };
		System.out.println("\nInterting elements");
		System.out.println("Input Elements :");
		System.out.print("[ ");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1]);
		System.out.println("]");

		System.out.println("\nInserted all the elements !!");

		for (int i = 0; i < arr.length; i++) {
			bt.add(arr[i]);
		}

		System.out.println("\nSearch : ");
		System.out.println("\nElement 24 : " + bt.containsNode(24));
		System.out.println("Element 12 : " + bt.containsNode(12));

		System.out.println("\nMax no : " + Q4BST.findMax(bt.root));
		System.out.println("Min no : " + bt.minvalue(bt.root));

		System.out.println("\nDelete Maximum and Minimum value");
		bt.deleteKey(Q4BST.findMax(bt.root));
		bt.deleteKey(bt.minvalue(bt.root));

		System.out.println("\nAfter deleting, new Max number : " + Q4BST.findMax(bt.root));
		System.out.println("After deleting, new Min number : " + bt.minvalue(bt.root));

	}
}
