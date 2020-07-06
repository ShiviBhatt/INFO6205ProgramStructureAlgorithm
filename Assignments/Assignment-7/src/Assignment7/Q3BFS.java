package Assignment7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Q3BFS {

	// Implementing graph using HashMap
	static HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
	static Set<Integer> set = new HashSet<>();

	// utility function to add edge in an undirected graph
	public static void addEdge(int a, int b) {
		set.add(a);
		set.add(b);
		if (graph.containsKey(a)) {
			LinkedList<Integer> l = graph.get(a);
			l.add(b);
			graph.put(a, l);
		} else {
			LinkedList<Integer> l = new LinkedList<>();
			l.add(b);
			graph.put(a, l);
		}
	}

	// Helper function for BFS
	public static void bfshelp(int s, HashSet<Integer> visited) {
		// Create a queue for BFS
		LinkedList<Integer> q = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		q.add(s);
		visited.add(s);

		while (!q.isEmpty()) {
			// Dequeue a vertex from queue and print it
			int f = q.poll();
			System.out.print((f) + " ");

			// Check whether the current node is
			// connected to any other node or not
			if (graph.containsKey(f)) {
				Iterator<Integer> i = graph.get(f).listIterator();

				// Get all adjacent vertices of the dequeued
				// vertex f. If an adjacent has not been visited,
				// then mark it visited and enqueue it

				while (i.hasNext()) {
					int n = i.next();
					if (!visited.contains(n)) {
						visited.add(n);
						q.add(n);
					}
				}
			}
		}

	}

	// BFS function to check each node
	public static void bfs(int start) {
		HashSet<Integer> visited = new HashSet<>();
		bfshelp(start, visited);

		for (int i : set) {
			if (!visited.contains(i)) {
				bfshelp(i, visited);
			}
		}

	}

	public static void main(String args[]) {

		addEdge(5, 6);
		addEdge(4, 6);
		addEdge(3, 7);
		addEdge(6, 7);
		addEdge(5, 7);
		addEdge(1, 4);
		addEdge(2, 4);
		addEdge(2, 3);
		addEdge(4, 7);
		addEdge(4, 8);
		addEdge(5, 9);

		// This is for reversing edges in undirected graph
		addEdge(4, 1);
		addEdge(6, 5);
		addEdge(6, 4);
		addEdge(7, 3);
		addEdge(7, 6);
		addEdge(7, 5);
		addEdge(4, 2);
		addEdge(3, 2);
		addEdge(7, 4);
		addEdge(8, 4);
		addEdge(9, 5);

		int start = 1; // initial vertex from which you will start constructing the BFS

		System.out.println("BFS of graph is:");

		// we are starting search from 0th vertex.
		bfs(start);
	}
}