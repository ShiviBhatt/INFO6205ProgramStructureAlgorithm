
package assignment9;

/**
 *
 * @author Shivi Bhatt
 */
public class BalanceSpanningTree {
	public static int getHeight(Node root) {
		if (root == null)
			return 0;
		return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
	}

	public static boolean isBalancedNaive(Node root) {
		if (root == null)
			return true;
		int heightdifference = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightdifference) > 1) {
			return false;
		} else {
			return isBalancedNaive(root.left) && isBalancedNaive(root.right);
		}
	}

	public static void main(String args[]) {
		BalanceSpanningTree balancedSpanningTree = new BalanceSpanningTree();
		balancedSpanningTree.run();
	}

	public void run() {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		System.out.println(" Is Tree Balanced : " + (new BalanceSpanningTree()).isBalancedNaive(root));
		root.right.right.right = new Node(40);
		root.right.right.right.right = new Node(45);
		System.out.println(" Is Tree Balanced : " + (new BalanceSpanningTree()).isBalancedNaive(root));
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
