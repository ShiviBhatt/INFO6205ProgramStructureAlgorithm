// Shivi Bhatt
// NUID: 001027605
package assignment6;

class Q6BinaryTree {

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
