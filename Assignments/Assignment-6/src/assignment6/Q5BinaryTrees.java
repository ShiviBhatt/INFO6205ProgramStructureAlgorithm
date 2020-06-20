package assignment6;

public class Q5BinaryTrees<type extends Comparable<type>> {
	public class Node {
		public type data;
		public Node left, right;

		public Node(type data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	Q5BinaryTrees() {
		root = null;
	}

	public void insert(type key) {
		root = insert(root, key);
	}

	public Node insert(Node root, type key) {
		if (root == null) {
			return new Node(key);
		} else if ((root.data).compareTo(key) < 0) {
			root.right = insert(root.right, key);
		} else if ((root.data).compareTo(key) > 0) {
			root.left = insert(root.left, key);
		}
		return root;
	}

	public void inorder() {
		inorder(root);
	}

	public void inorder(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null)
			inorder(root.left);
		System.out.print(root.data + " ");
		if (root.right != null)
			inorder(root.right);

	}

	public boolean search(type key) {
		return search(root, key);
	}

	public boolean search(Node root, type key) {
		if (root == null) {
			return false;
		} else if ((root.data).compareTo(key) == 0)
			return true;
		else if ((root.data).compareTo(key) < 0)
			return search(root.right, key);
		else if ((root.data).compareTo(key) > 0)
			return search(root.left, key);
		return false;
	}

	public type findMin() {
		return findMin(root);
	}

	public type findMin(Node root) {
		if (root == null) {
			return null;
		} else if (root.left != null) {
			return findMin(root.left);
		}
		return root.data;
	}

	public type findMax() {
		return findMax(root);
	}

	public type findMax(Node root) {
		if (root == null) {
			return null;
		} else if (root.right != null) {
			return findMax(root.right);
		}
		return root.data;
	}

	public void delete(type key) {
		root = delete(root, key);
	}

	public Node delete(Node root, type key) {
		if (root == null) {
			return null;
		}
		if ((root.data).compareTo(key) < 0) {
			root.right = delete(root.right, key);
		} else if ((root.data).compareTo(key) > 0) {
			root.left = delete(root.left, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.data = findMin(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	public void deleteMax() {
		type element = findMax(root);
		delete(element);
	}

	public void deleteMin() {
		type element = findMin(root);
		delete(element);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Q5BinaryTrees<Integer> bst = new Q5BinaryTrees<Integer>();
		bst.insert(3);
		bst.insert(7);
		bst.insert(9);
		bst.insert(23);
		bst.insert(45);
		bst.insert(1);
		bst.insert(5);
		bst.insert(14);
		bst.insert(55);
		bst.insert(24);
		bst.insert(13);
		bst.insert(11);
		bst.insert(8);
		bst.insert(19);
		bst.insert(4);
		bst.insert(31);
		bst.insert(35);
		bst.insert(56);
		System.out.println("Question 1: a)");
		System.out.println("Tree in inorder");
		bst.inorder();
		System.out.println();

		bst.delete(13);
		System.out.println("Question 1: g)");
		System.out.println("Tree after deleting 13");
		bst.inorder();
		System.out.println();

		bst.insert(17);
		bst.insert(22);
		bst.insert(32);
		bst.insert(6);
		bst.insert(33);
		System.out.println("Question 1: i)");
		System.out.println("Tree in inorder after insert");
		bst.inorder();
		System.out.println();
		System.out.println("Question 1: i)");
		System.out.println("Does BST contain 17? " + bst.search(17));
		System.out.println("Does BST contain 100? " + bst.search(100));
		System.out.println("Min in BST: " + bst.findMin());
		System.out.println("Max in BST: " + bst.findMax());

		System.out.println("Question 1: j)");
		bst.deleteMax();
		System.out.println("Tree after deleteing max element");
		bst.inorder();

		bst.deleteMin();
		bst.deleteMax();
		System.out.println("Tree after deleteing min element");

		System.out.println("--------------------------");
		System.out.println("Question 5:");
		Q5BinaryTrees<Character> bst1 = new Q5BinaryTrees<Character>();
		bst1.insert('a');
		bst1.insert('b');
		bst1.insert('c');
		bst1.insert('d');
		bst1.insert('e');
		bst1.insert('f');
		bst1.insert('g');
		bst1.insert('h');
		bst1.insert('i');
		bst1.insert('j');
		bst1.insert('k');
		System.out.println("Tree in inorder");
		bst1.inorder();
		System.out.println();
		System.out.println("Max in BST: " + bst1.findMax());
		System.out.println("--------------------------");
		System.out.println("Question 6: a)");
		Q5BinaryTrees<Integer> bst2 = new Q5BinaryTrees<Integer>();
		bst2.insert(30);
		bst2.insert(40);
		bst2.insert(23);
		bst2.insert(58);
		bst2.insert(48);
		bst2.insert(26);
		bst2.insert(11);
		bst2.insert(13);
		System.out.println("Tree in inorder");
		bst2.inorder();
		System.out.println();

	}

}
