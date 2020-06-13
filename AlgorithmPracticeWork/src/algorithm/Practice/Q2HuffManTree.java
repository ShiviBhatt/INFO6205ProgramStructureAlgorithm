package algorithm.Practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q2HuffManTree {

	static class Node {
		Character data;
		int frequency;
		Node left;
		Node right;
	}

	// Comparator to sort in ascending order, this is for min heap
	static class HuffManComparator implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			return n1.frequency - n2.frequency;
		}
	}

	public static void main(String[] args) {

		// String input = "There are sunny days, rainy days, and windy days";
		String input = "There are sunny days";

		// no need of encoding for empty string
		if (input == null || input.length() == 0) {
			System.out.println("No compression done as string is empty");
			return;
		}

		// This is a corner case, not very easy to handle for single character
		if (input.length() == 1) {
			System.out.println("Encoded String = " + 1);
			return;
		}

		Node root = null;

		// min heap
		PriorityQueue<Node> pq = new PriorityQueue<>(new HuffManComparator());

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				int curCount = map.get(input.charAt(i));
				map.put(input.charAt(i), curCount + 1);

			} else {
				map.put(input.charAt(i), 1);
			}
		}

		for (Map.Entry<Character, Integer> item : map.entrySet()) {
			char data = item.getKey();
			int frequency = item.getValue();
			Node node = new Node();
			node.data = data;
			node.frequency = frequency;
			pq.add(node);
		}

		while (pq.size() > 1) {

			Node left = pq.poll();
			Node right = pq.poll();

			Node aggregationNode = new Node();
			aggregationNode.frequency = left.frequency + right.frequency;
			aggregationNode.data = null;

			aggregationNode.left = left;
			aggregationNode.right = right;

			pq.add(aggregationNode);

			root = aggregationNode;

		}

		if (!pq.isEmpty()) {
			root = pq.poll();
		}

		Map<Character, String> encodingMap = new HashMap<>();
		getCharacterEncodings(root, "", encodingMap);
		printEncodedString(input, encodingMap);

	}

	private static void printEncodedString(String input, Map<Character, String> encodingMap) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			String encoding = encodingMap.get(input.charAt(i));
			builder.append(encoding);
		}
		System.out.println("Original String = " + input);
		System.out.println("Original String length = " + input.length() * 8);
		System.out.println("Encoded String = " + builder.toString());
		System.out.println("Encoded String length = " + builder.length());
		System.out.println("Percentage Compression = "
				+ ((input.length() * 8.0 - builder.length() * 1.0) / (input.length() * 8.0) * 100.0));

	}

	private static void getCharacterEncodings(Node root, String value, Map<Character, String> encodingMap) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.println("Character c = " + root.data + " Encoded String = " + value);
			encodingMap.put(root.data, value);
		}

		getCharacterEncodings(root.left, value + "0", encodingMap);
		getCharacterEncodings(root.right, value + "1", encodingMap);
	}

}
