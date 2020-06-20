// Shivi Bhatt
// NUID: 001027605
//This class has 2-3 tree, 2-3-4 tree
package assignment6;

import java.util.LinkedList;
import java.util.Queue;

class Two_Three_Tree {

	private int size;
	private TreeNodeStructure root;
	private boolean successfulInsertion;
	private boolean successfulDeletion;
	private boolean split;
	private boolean underflow;
	private boolean first;
	private boolean singleNodeUnderflow;

	private enum Nodes {

		LEFT, MIDDLE, RIGHT, DUMMY;
	}

	public Two_Three_Tree() {

		size = 0;
		root = null;
		successfulInsertion = false;
		successfulDeletion = false;
		underflow = false;
		singleNodeUnderflow = false;
		split = false;
		first = false;
	}

	private class Node {

	}

	private class TreeNodeStructure extends Node {

		int keys[];
		Node children[];
		int degree;

		TreeNodeStructure() {

			keys = new int[2];
			children = new Node[3];
			degree = 0;
		}

		void print() {

			if (degree == 1) {
				System.out.print("(-,-)");
			} else if (degree == 2) {
				System.out.print("(" + keys[0] + ",-) ");
			} else {
				System.out.print("(" + keys[0] + "," + keys[1] + ") ");
			}
		}
	}

	private class LeafNode extends Node {

		int key; // to store the value

		LeafNode(int key) {
			this.key = key;
		}
	}

	private void insertKey(int key) {

		Node[] array = new Node[2];

		array = insert(key, root);

		if (array[1] == null) {

			root = (TreeNodeStructure) array[0];
		} else {

			TreeNodeStructure treeRoot = new TreeNodeStructure();
			treeRoot.children[0] = array[0];
			treeRoot.children[1] = array[1];
			updateTree(treeRoot);
			root = treeRoot;
		}
	}

	private Node[] insert(int key, Node n) {

		Node array[] = new Node[2];

		// This array of node stores the result after the recursive insert has returned
		Node catchArray[] = new Node[2];

		TreeNodeStructure t = null; // Initialize t to null

		// If the node is a TreeNodeStructure
		if (n instanceof TreeNodeStructure) {
			t = (TreeNodeStructure) n;
		}

		// If the root is null, this means it is the first node
		if (root == null && !first) {
			first = true; // Switch to make this if false for next recursive call

			// Create a new TreeNodeStructure
			TreeNodeStructure newNode = new TreeNodeStructure();
			t = newNode;
			// Call insert with the given value
			t.children[0] = insert(key, t.children[0])[0];
			updateTree(t); // Update the tree

			// We will return this array
			// Make first element in the array store the reference of this TreeNodeStructure
			array[0] = t;
			array[1] = null; // Make second element null

		} // If the node on which insert was called is a TreeNodeStructure and
			// stores references to TreeNodeStructures
		else if (t != null && !(t.children[0] instanceof LeafNode)) {
			// If the key to be inserted is less than the first key
			if (key < t.keys[0]) {
				// Recursively call insert on the left children node
				catchArray = insert(key, t.children[0]);
				// Store the reference returned by the call
				t.children[0] = catchArray[0];

				// If split has occurred
				if (split) {
					// If the degree of current node is less than or equal to 2
					if (t.degree <= 2) {
						// Make split false we will handle it right here
						split = false;
						// Attach new nodes and update the tree
						t.children[2] = t.children[1];
						t.children[1] = catchArray[1];
						updateTree(t);
						array[0] = t;
						array[1] = null;
					} else if (t.degree > 2) {
						// In this case, we are gonna pass the two nodes back
						// up the chain
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = t.children[1];
						newNode.children[1] = t.children[2];
						updateTree(newNode);
						t.children[1] = catchArray[1];
						t.children[2] = null;
						updateTree(t);
						array[0] = t;
						array[1] = newNode;
					}
				} else {
					// If there was no split simply update the tree and
					// pass the reference up the tree
					updateTree(t);
					array[0] = t;
					array[1] = null;
				} // if else for split ends here
			} // If for key < t.keys[0] ends here
				// If the key to be inserted is less than the first and greater than the second
				// or second is null
			else if (key >= t.keys[0] && (t.children[2] == null || key < t.keys[1])) {
				// Recursively call insert on the middle children node
				catchArray = insert(key, t.children[1]);
				// Store the reference returned by the call
				t.children[1] = catchArray[0];

				// If split has occurred
				if (split) {
					// If the degree of current node is less than or equal to 2
					if (t.degree <= 2) {
						// Make split false we will handle it right here
						split = false;
						// Attach new nodes and update the tree
						t.children[2] = catchArray[1];
						updateTree(t);
						array[0] = t;
						array[1] = null;
					} else if (t.degree > 2) {
						// In this case, we are gonna pass the two nodes back
						// up the chain hoping it will be handled there
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = catchArray[1];
						newNode.children[1] = t.children[2];
						updateTree(newNode);
						t.children[2] = null;
						updateTree(t);
						array[0] = t;
						array[1] = newNode;
					}
				} else {
					// If there was no split simply update the tree and
					// pass the reference up the tree
					updateTree(t);
					array[0] = t;
					array[1] = null;
				} // if else for split ends here
			} // If for key >= t.keys[0] ends here
				// If the key to be inserted is greater than second key
			else if (key >= t.keys[1]) {
				// Recursively call insert on the right children node
				catchArray = insert(key, t.children[2]);
				// Store the reference returned by the call
				t.children[2] = catchArray[0];

				// If split has occurred
				if (split) {
					if (t.degree > 2) {
						// In this case, we are gonna pass the two nodes back
						// up the chain hoping it will be handled there
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = catchArray[0];
						newNode.children[1] = catchArray[1];
						updateTree(newNode);
						t.children[2] = null;
						updateTree(t);
						array[0] = t;
						array[1] = newNode;

					}
				} else {

					updateTree(t);
					array[0] = t;
					array[1] = null;
				}
			}
		}

		else if (t != null && t.children[0] instanceof LeafNode) {

			LeafNode l1 = null, l2 = null, l3 = null;
			if (t.children[0] != null && t.children[0] instanceof LeafNode) {
				l1 = (LeafNode) t.children[0];
			}
			if (t.children[1] != null && t.children[1] instanceof LeafNode) {
				l2 = (LeafNode) t.children[1];
			}
			if (t.children[2] != null && t.children[2] instanceof LeafNode) {
				l3 = (LeafNode) t.children[2];
			}

			if (t.degree <= 2) {

				if (t.degree == 1 && key > l1.key) {
					LeafNode leaf = new LeafNode(key);
					t.children[1] = leaf;
				} else if (t.degree == 1 && key < l1.key) {
					LeafNode leaf = new LeafNode(key);
					t.children[1] = l1;
					t.children[0] = leaf;
				} else if (t.degree == 2 && key < l1.key) {
					LeafNode leaf = new LeafNode(key);
					t.children[2] = l2;
					t.children[1] = l1;
					t.children[0] = leaf;
				} else if (t.degree == 2 && key < l2.key && key > l1.key) {
					LeafNode leaf = new LeafNode(key);
					t.children[2] = l2;
					t.children[1] = leaf;
				} else if (t.degree == 2) {
					LeafNode leaf = new LeafNode(key);
					t.children[2] = leaf;
				}

				updateTree(t);
				array[0] = t;
				array[1] = null;
			} else if (t.degree > 2) {

				split = true;

				if (key < l1.key) {

					LeafNode leaf = new LeafNode(key);
					TreeNodeStructure newNode = new TreeNodeStructure();
					t.children[0] = leaf;
					t.children[1] = l1;
					t.children[2] = null;
					updateTree(t);
					newNode.children[0] = l2;
					newNode.children[1] = l3;
					updateTree(newNode);
					array[0] = t;
					array[1] = newNode;
				} else if (key >= l1.key && key < l2.key) {

					LeafNode leaf = new LeafNode(key);
					TreeNodeStructure newNode = new TreeNodeStructure();
					t.children[1] = leaf;
					t.children[2] = null;
					updateTree(t);
					newNode.children[0] = l2;
					newNode.children[1] = l3;
					updateTree(newNode);
					array[0] = t;
					array[1] = newNode;
				} else if (key >= l2.key && key < l3.key) {

					LeafNode leaf = new LeafNode(key);
					t.children[2] = null;
					updateTree(t);
					TreeNodeStructure newNode = new TreeNodeStructure();
					newNode.children[0] = leaf;
					newNode.children[1] = l3;
					updateTree(newNode);
					array[0] = t;
					array[1] = newNode;
				} else if (key >= l3.key) {

					LeafNode leaf = new LeafNode(key);
					t.children[2] = null;
					updateTree(t);
					TreeNodeStructure newNode = new TreeNodeStructure();
					newNode.children[0] = l3;
					newNode.children[1] = leaf;
					updateTree(newNode);
					array[0] = t;
					array[1] = newNode;
				}
			}

			successfulInsertion = true;
		} else if (n == null) {

			successfulInsertion = true;
			array[0] = new LeafNode(key);
			array[1] = null;
			return array;
		}

		return array;
	}

	private Node remove(int key, Node n) {

		TreeNodeStructure t = null;
		if (n instanceof TreeNodeStructure) {
			t = (TreeNodeStructure) n;
		}

		if (n == null) {
			return null;
		}

		if (t != null && t.children[0] instanceof TreeNodeStructure) {
			// If the given key to be deleted is less than the first key
			if (key < t.keys[0]) {
				// Perform deletion on first child with the same key
				t.children[0] = remove(key, t.children[0]);

				// If after deletion there is a degree 1 node in the tree
				if (singleNodeUnderflow) {
					// Get the reference of both of the child nodes
					TreeNodeStructure child = (TreeNodeStructure) t.children[0];
					TreeNodeStructure rightChild = (TreeNodeStructure) t.children[1];

					// If the right child has a degree of 2
					// Attach the child to the rightchild and update the tree
					if (rightChild.degree == 2) {
						rightChild.children[2] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[0];
						rightChild.children[0] = child;
						updateTree(rightChild);
						t.children[0] = rightChild;
						t.children[1] = t.children[2];
						t.children[2] = null;

						// If the degree of the current TreeNodeStructure is 2
						// then it will also underflow after this
						if (t.degree == 2) {
							singleNodeUnderflow = true;
							t = (TreeNodeStructure) t.children[0];
						} else {
							singleNodeUnderflow = false;
						}
					} // If the right child has a degree of 3
						// Borrow one child from rightchild and attach it to
						// newly created tree node which has 2 children
						// one a child from rightchild and the other child of
						// the Tree node which underflew
					else if (rightChild.degree == 3) {
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = t.children[0];
						newNode.children[1] = rightChild.children[0];
						t.children[0] = newNode;
						updateTree(newNode);
						rightChild.children[0] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[2];
						rightChild.children[2] = null;
						updateTree(rightChild);
						singleNodeUnderflow = false;
					}
				} // if for singleNodeUnderflow ends here
					// Else if there was an underflow
				else if (underflow) {
					// We will handle it here
					underflow = false;
					// Get the references of children nodes
					TreeNodeStructure child = (TreeNodeStructure) t.children[0];
					TreeNodeStructure rightChild = (TreeNodeStructure) t.children[1];

					// If the degree of rightchild is 3 then borrow one
					// child from the rightchild and attach it to the child
					if (rightChild.degree == 3) {
						Node reference = rightChild.children[0];
						rightChild.children[0] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[2];
						rightChild.children[2] = null;
						updateTree(rightChild);
						child.children[1] = reference;
						updateTree(child);
					} // If the degree of rightchild is 2 then merge child
						// and rightchild into one node
					else if (rightChild.degree == 2) {
						Node reference = child.children[0];
						rightChild.children[2] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[0];
						rightChild.children[0] = reference;
						updateTree(rightChild);
						t.children[0] = rightChild;

						// Now if the degree of the TreeNodeStructure was 3
						// we are good this won't underflow after merge
						if (t.degree == 3) {
							t.children[1] = t.children[2];
							t.children[2] = null;
						} // But if it's less than 3, it will certainly underflow
							// In this case we are gonna pass the problem up the tree
						else {
							Node ref = t.children[0];
							t = (TreeNodeStructure) ref;
							singleNodeUnderflow = true;
						} // nested inner if else ends here
					} // inner if else ends here
				} // outer if else ends here
				updateTree(t); // update the tree
			} // If the given key to be deleted is in between first and second key
			else if (key >= t.keys[0] && (t.children[2] == null || key < t.keys[1])) {
				// Perform deletion on second child with the same key
				t.children[1] = remove(key, t.children[1]);

				// If after deletion there is a degree 1 node in the tree
				if (singleNodeUnderflow) {

					// Get references of all the child nodes
					TreeNodeStructure leftChild = (TreeNodeStructure) t.children[0];
					TreeNodeStructure child = (TreeNodeStructure) t.children[1];
					TreeNodeStructure rightChild = (TreeNodeStructure) t.children[2];

					// If the left child has a degree of 2
					// Attach the child to the leftchild and update the tree
					if (leftChild.degree == 2) {
						leftChild.children[2] = child;
						t.children[1] = rightChild;
						t.children[2] = null;
						updateTree(leftChild);

						// If the degree of the current TreeNodeStructure is 2
						// then it will also underflow after this merge
						if (t.degree == 2) {
							singleNodeUnderflow = true;
							t = (TreeNodeStructure) t.children[0];
						} else {
							singleNodeUnderflow = false;
						}
					} // If the right child has a degree of 2
						// Attach the child to the rightchild and update the tree
					else if (rightChild != null && rightChild.degree == 2) {
						rightChild.children[2] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[0];
						rightChild.children[0] = child;
						updateTree(rightChild);
						t.children[1] = rightChild;
						t.children[2] = null;
						singleNodeUnderflow = false;

					}

					else if (leftChild.degree == 3) {
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = leftChild.children[2];
						newNode.children[1] = child;
						t.children[1] = newNode;
						updateTree(newNode);
						updateTree(leftChild);
						singleNodeUnderflow = false;
					} // If the degree of rightchild is 3 then borrow one

					else if (rightChild != null && rightChild.degree == 3) {
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = child;
						newNode.children[1] = rightChild.children[0];
						rightChild.children[0] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[2];
						rightChild.children[2] = null;
						t.children[1] = newNode;
						updateTree(newNode);
						updateTree(rightChild);
						singleNodeUnderflow = false;
					}
				} // Else if there was an underflow
				else if (underflow) {

					underflow = false;

					TreeNodeStructure leftChild = (TreeNodeStructure) t.children[0];
					TreeNodeStructure child = (TreeNodeStructure) t.children[1];
					TreeNodeStructure rightChild = (TreeNodeStructure) t.children[2];

					if (leftChild.degree == 3) {
						Node reference = leftChild.children[2];
						leftChild.children[2] = null;
						child.children[1] = child.children[0];
						child.children[0] = reference;
						updateTree(leftChild);
						updateTree(child);
					}

					else if (rightChild != null && rightChild.degree == 3) {
						Node reference = rightChild.children[0];
						rightChild.children[0] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[2];
						rightChild.children[2] = null;
						updateTree(rightChild);
						child.children[1] = reference;
						updateTree(child);
					}

					else if (leftChild.degree == 2) {
						Node reference = child.children[0];
						leftChild.children[2] = reference;
						updateTree(leftChild);
						t.children[1] = null;

						if (t.degree == 3) {
							t.children[1] = t.children[2];
							t.children[2] = null;
						}

						else {
							singleNodeUnderflow = true;
							t = (TreeNodeStructure) t.children[0];
						}
					}

					else if (rightChild != null && rightChild.degree == 2) {
						Node reference = child.children[0];
						rightChild.children[2] = rightChild.children[1];
						rightChild.children[1] = rightChild.children[0];
						rightChild.children[0] = reference;
						updateTree(rightChild);
						t.children[1] = rightChild;
						t.children[2] = null;
						singleNodeUnderflow = false;
					}
				}
				updateTree(t);
			} else if (key >= t.keys[1]) {

				t.children[2] = remove(key, t.children[2]);

				if (singleNodeUnderflow) {

					TreeNodeStructure child = (TreeNodeStructure) t.children[2];
					TreeNodeStructure leftChild = (TreeNodeStructure) t.children[1];

					if (leftChild.degree == 2) {
						leftChild.children[2] = child;
						t.children[2] = null;
						updateTree(leftChild);
					}

					else if (leftChild.degree == 3) {
						TreeNodeStructure newNode = new TreeNodeStructure();
						newNode.children[0] = leftChild.children[2];
						newNode.children[1] = t.children[2];
						t.children[2] = newNode;
						updateTree(newNode);
						updateTree(leftChild);
					}

					singleNodeUnderflow = false;
				} else if (underflow) {

					underflow = false;

					TreeNodeStructure leftChild = (TreeNodeStructure) t.children[1];
					TreeNodeStructure child = (TreeNodeStructure) t.children[2];

					if (leftChild.degree == 3) {
						Node reference = leftChild.children[2];
						leftChild.children[2] = null;
						child.children[1] = child.children[0];
						child.children[0] = reference;
						updateTree(leftChild);
						updateTree(child);
					}

					else if (leftChild.degree == 2) {
						Node reference = child.children[0];
						leftChild.children[2] = reference;
						updateTree(leftChild);
						t.children[2] = null;
					}
				}
				updateTree(t);
			}
		} else if (t != null && t.children[0] instanceof LeafNode) {

			LeafNode l1 = null, l2 = null, l3 = null;
			if (t.children[0] != null && t.children[0] instanceof LeafNode) {
				l1 = (LeafNode) t.children[0];
			}
			if (t.children[1] != null && t.children[1] instanceof LeafNode) {
				l2 = (LeafNode) t.children[1];
			}
			if (t.children[2] != null && t.children[2] instanceof LeafNode) {
				l3 = (LeafNode) t.children[2];
			}

			if (t.degree == 3) {

				if (key == l1.key) {
					t.children[0] = l2;
					t.children[1] = l3;
					t.children[2] = null;
				} else if (key == l2.key) {
					t.children[1] = l3;
					t.children[2] = null;
				} else if (key == l3.key) {
					t.children[2] = null;
				}

				updateTree(t);
			} else if (t.degree == 2) {

				underflow = true;

				if (l1.key == key) {
					t.children[0] = l2;
					t.children[1] = null;
				} else if (l2.key == key) {
					t.children[1] = null;
				}
			} else if (t.degree == 1) {

				if (l1.key == key) {
					t.children[0] = null;
				}
			}

			successfulDeletion = true;
		}
		return t;
	}

	private void updateTree(TreeNodeStructure t) {

		if (t != null) {

			if (t.children[2] != null && t.children[1] != null && t.children[0] != null) {

				t.degree = 3;

				t.keys[0] = getValueForKey(t, Nodes.LEFT);
				t.keys[1] = getValueForKey(t, Nodes.RIGHT);
			} else if (t.children[1] != null && t.children[0] != null) {

				t.degree = 2;

				t.keys[0] = getValueForKey(t, Nodes.LEFT);
				t.keys[1] = 0;
			} else if (t.children[0] != null) {

				t.degree = 1;

				t.keys[1] = t.keys[0] = 0;
			}
		}
	}

	private int getValueForKey(Node n, Nodes whichVal) {

		int key = -1;

		TreeNodeStructure t = null;
		LeafNode l = null;
		if (n instanceof TreeNodeStructure) {
			t = (TreeNodeStructure) n;
		} else {
			l = (LeafNode) n;
		}

		// If it is a leaf node just return the key
		if (l != null) {
			key = l.key;
		}

		if (t != null) {

			if (null != whichVal) {
				switch (whichVal) {

				case LEFT:

					key = getValueForKey(t.children[1], Nodes.DUMMY);
					break;

				case RIGHT:

					key = getValueForKey(t.children[2], Nodes.DUMMY);
					break;

				case DUMMY:

					key = getValueForKey(t.children[0], Nodes.DUMMY);
					break;
				default:
					break;
				}
			}
		}

		return key;
	}

	private boolean search(int key, Node n) {

		boolean found = false;

		TreeNodeStructure t = null;
		LeafNode l = null;
		if (n instanceof TreeNodeStructure) {
			t = (TreeNodeStructure) n;
		} else {
			l = (LeafNode) n;
		}

		if (t != null) {

			if (t.degree == 1) {

				found = search(key, t.children[0]);
			} else if (t.degree == 2 && key < t.keys[0]) {

				found = search(key, t.children[0]);
			} else if (t.degree == 2 && key >= t.keys[0]) {

				found = search(key, t.children[1]);
			} else if (t.degree == 3 && key < t.keys[0]) {

				found = search(key, t.children[0]);
			} else if (t.degree == 3 && key >= t.keys[0] && key < t.keys[1]) {

				found = search(key, t.children[1]);
			} else if (t.degree == 3 && key >= t.keys[1]) {

				found = search(key, t.children[2]);
			}
		} else if (l != null && key == l.key) {
			return true;
		}

		return found;
	}

	private void keyOrderList(Node n) {

		TreeNodeStructure t = null;
		LeafNode l = null;
		if (n instanceof TreeNodeStructure) {
			t = (TreeNodeStructure) n;
		} else {
			l = (LeafNode) n;
		}

		if (t != null) {

			if (t.children[0] != null) {

				keyOrderList(t.children[0]);
			}

			if (t.children[1] != null) {

				keyOrderList(t.children[1]);
			}

			if (t.children[2] != null) {

				keyOrderList(t.children[2]);
			}
		} else if (l != null) {

			System.out.print(l.key + " ");
		}
	}

	private void bfsList(Node n) {

		Queue<Node> queueOne = new LinkedList<>();
		Queue<Node> queueTwo = new LinkedList<>();

		if (n == null) {
			return;
		}

		queueOne.add(n);

		Node first = null;
		TreeNodeStructure t = null;

		while (!queueOne.isEmpty() || !queueTwo.isEmpty()) {

			while (!queueOne.isEmpty()) {

				first = queueOne.poll();

				if (first instanceof TreeNodeStructure) {
					t = (TreeNodeStructure) first;
					t.print();
				}

				if (t.children[0] != null && !(t.children[0] instanceof LeafNode)) {
					queueTwo.add(t.children[0]);
				}
				if (t.children[1] != null && !(t.children[1] instanceof LeafNode)) {
					queueTwo.add(t.children[1]);
				}
				if (t.children[2] != null && !(t.children[2] instanceof LeafNode)) {
					queueTwo.add(t.children[2]);
				}

			}

			if (!queueOne.isEmpty() || !queueTwo.isEmpty()) {
				System.out.println();
			}

			while (!queueTwo.isEmpty()) {

				first = queueTwo.poll();

				if (first instanceof TreeNodeStructure) {
					t = (TreeNodeStructure) first;
					t.print();
				}

				if (t.children[0] != null && !(t.children[0] instanceof LeafNode)) {
					queueOne.add(t.children[0]);
				}
				if (t.children[1] != null && !(t.children[1] instanceof LeafNode)) {
					queueOne.add(t.children[1]);
				}
				if (t.children[2] != null && !(t.children[2] instanceof LeafNode)) {
					queueOne.add(t.children[2]);
				}

			}

			if (!queueOne.isEmpty() || !queueTwo.isEmpty()) {
				System.out.println();
			}
		}

		System.out.println();
		keyOrderList(root);
		System.out.println();
	}

	private int height(Node n) {

		TreeNodeStructure t = null;
		LeafNode leaf1 = null;
		if (n instanceof TreeNodeStructure) {
			t = (TreeNodeStructure) n;
		} else {
			leaf1 = (LeafNode) n;
		}

		if (t != null) {

			return 1 + height(t.children[0]);
		}

		return 0;
	}

	public boolean insert(int key) {

		boolean insert = false;

		split = false;

		if (!search(key)) {

			insertKey(key);
		}

		if (successfulInsertion) {

			size++;
			insert = successfulInsertion;
			successfulInsertion = false;
		}
		return insert;
	}

	public boolean search(int key) {

		return search(key, root);
	}

	public boolean remove(int key) {

		boolean delete = false;
		singleNodeUnderflow = false;
		underflow = false;

		if (search(key)) {

			root = (TreeNodeStructure) remove(key, root);

			if (root.degree == 1 && root.children[0] instanceof TreeNodeStructure) {

				root = (TreeNodeStructure) root.children[0];
			}
		}

		if (successfulDeletion) {

			size--;
			delete = successfulDeletion;
			successfulDeletion = false;
		}

		return delete;
	} // remove() ends here

	public void keyOrderList() {

		System.out.println("Keys");
		keyOrderList(root);
		System.out.println();
	}

	public void bfsList() {

		System.out.println("Tree");
		bfsList(root);
	}

	public int numberOfNodes() {

		return size;
	}

	public int height() {

		return height(root);
	}

}

class BT {

	TreeNodeStructure root = null;

	class TreeNodeStructure {

		int data;
		TreeNodeStructure leftNode;
		TreeNodeStructure rightNode;

		public TreeNodeStructure(int paramData) {
			data = paramData;
		}
	}

	TreeNodeStructure insertElement(TreeNodeStructure currentNode, int value) {
		if (currentNode == null) {
			return new TreeNodeStructure(value);
		} else {
			if (value < currentNode.data) {
				currentNode.leftNode = insertElement(currentNode.leftNode, value);
			} else if (value > currentNode.data) {
				currentNode.rightNode = insertElement(currentNode.rightNode, value);
			} else {
				return currentNode;
			}
		}
		return currentNode;
	}

	boolean searchInBinaryTree(int valueTobeSearched, TreeNodeStructure currentNode) {
		if (currentNode == null) {
			return false;
		}
		if (currentNode.data == valueTobeSearched) {
			return true;
		} else {
			if (valueTobeSearched < currentNode.data) {

				return searchInBinaryTree(valueTobeSearched, currentNode.leftNode);
			} else {

				return searchInBinaryTree(valueTobeSearched, currentNode.rightNode);
			}
		}
	}

	int maximumElement(TreeNodeStructure currentNode) {
		if (currentNode.rightNode == null) {
			return currentNode.data;
		} else {
			int maximumElement = maximumElement(currentNode.rightNode);
			return maximumElement;
		}
	}

	TreeNodeStructure deleteMinimum(TreeNodeStructure currentNode) {
		if (currentNode.leftNode == null) {
			return currentNode.rightNode;
		} else {
			currentNode.leftNode = deleteMinimum(currentNode.leftNode);
			return currentNode;
		}
	}

	TreeNodeStructure deleteMaximum(TreeNodeStructure currentNode) {
		if (currentNode.rightNode == null) {
			return currentNode.leftNode;
		} else {
			currentNode.rightNode = deleteMaximum(currentNode.rightNode);
			return currentNode;
		}
	}
}

class DataNode {

	public double dData;

	public DataNode(double dd) // constructor
	{
		dData = dd;
	}

	public void displayItem() {
		System.out.print("/" + dData);
	}

}

class Node {

	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private DataNode itemArray[] = new DataNode[ORDER - 1];

	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}

	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	public Node getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}

	public int getNumItems() {
		return numItems;
	}

	public DataNode getItem(int index) // get DataNode at index
	{
		return itemArray[index];
	}

	public boolean isFull() {
		return (numItems == ORDER - 1) ? true : false;
	}

	public int findItem(double key)

	{
		for (int j = 0; j < ORDER - 1; j++) {
			if (itemArray[j] == null) {
				break;
			} else if (itemArray[j].dData == key) {
				return j;
			}
		}
		return -1;
	}

	public int insertItem(DataNode newItem) {

		numItems++;
		double newKey = newItem.dData;

		for (int j = ORDER - 2; j >= 0; j--) {
			if (itemArray[j] == null) {
				continue;
			} else {
				double itsKey = itemArray[j].dData;
				if (newKey < itsKey) {
					itemArray[j + 1] = itemArray[j];
				} else {
					itemArray[j + 1] = newItem;
					return j + 1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}

	public DataNode removeItem() {

		DataNode temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}

	public void displayNode() {
		for (int j = 0; j < numItems; j++) {
			itemArray[j].displayItem();
		}
		System.out.println("/");
	}

}

class Tree234 {

	private Node root = new Node();

	public int find(double key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1) {
				return childNumber;
			} else if (curNode.isLeaf()) {
				return -1;
			} else {
				curNode = getNextChild(curNode, key);
			}
		}
	}

	public void insert(double dValue)

	{
		Node curNode = root;
		DataNode tempItem = new DataNode(dValue);

		while (true) {
			if (curNode.isFull()) {
				split(curNode);
				curNode = curNode.getParent();

				curNode = getNextChild(curNode, dValue);
			} else if (curNode.isLeaf()) {
				break;
			} else {
				curNode = getNextChild(curNode, dValue);
			}
		}

		curNode.insertItem(tempItem);
	}

	public void split(Node thisNode) {

		DataNode itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;

		itemC = thisNode.removeItem();
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);

		Node newRight = new Node();

		if (thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		} else {
			parent = thisNode.getParent();
		}

		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();

		for (int j = n - 1; j > itemIndex; j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}

		parent.connectChild(itemIndex + 1, newRight);

		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}

	public Node getNextChild(Node theNode, double theValue) {

		int j;

		int numItems = theNode.getNumItems();
		for (j = 0; j < numItems; j++) {
			if (theValue < theNode.getItem(j).dData) {
				return theNode.getChild(j);
			}
		}
		return theNode.getChild(j);
	}

	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}

	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level=" + level + " child=" + childNumber + " ");
		thisNode.displayNode();

		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++) {
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null) {
				recDisplayTree(nextNode, level + 1, j);
			} else {
				return;
			}
		}
	}

}
