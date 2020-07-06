package Assignment7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Q5BFSRecursive {
	// Perform BFS recursively on graph
	public static void recursiveBFS(Graph graph, Queue<Integer> q, boolean[] discovered) {
		if (q.isEmpty())
			return;

		// pop front node from queue and print it
		int v = q.poll();
		System.out.print(v + " ");

		// do for every edge (v -> u)
		for (int u : graph.adjList.get(v)) {
			if (!discovered[u]) {
				// mark it discovered and push it into queue
				discovered[u] = true;
				q.add(u);
			}
		}

		recursiveBFS(graph, q, discovered);
	}

	// Recursive Java implementation of Breadth first search
	public static void main(String[] args) {
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 3), new Edge(0, 8), new Edge(1, 0), new Edge(1, 7),
				new Edge(2, 3), new Edge(2, 7), new Edge(2, 5), new Edge(3, 0), new Edge(3, 4), new Edge(3, 2),
				new Edge(4, 8), new Edge(4, 3), new Edge(5, 2), new Edge(5, 6), new Edge(6, 5), new Edge(7, 1),
				new Edge(7, 2), new Edge(8, 0), new Edge(8, 4)
		// vertex 0, 13 and 14 are single nodes
		);

		// Set number of vertices in the graph
		final int N = 9;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// create a queue used to do BFS
		Queue<Integer> q = new ArrayDeque<>();

		// Do BFS traversal from all undiscovered nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < N; i++) {
			if (discovered[i] == false) {
				// mark source vertex as discovered
				discovered[i] = true;

				// push source vertex into the queue
				q.add(i);

				// start BFS traversal from vertex i
				recursiveBFS(graph, q, discovered);
			}
		}
	}

	// data structure to store graph edges
	static class Edge {
		int source, dest;

		public Edge(int source, int dest) {
			this.source = source;
			this.dest = dest;
		}
	}

	// class to represent a graph object
	static class Graph {
		// A List of Lists to represent an adjacency list
		List<List<Integer>> adjList = null;

		// Constructor
		Graph(List<Edge> edges, int N) {
			adjList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				adjList.add(new ArrayList<>());
			}

			// add edges to the undirected graph
			for (Edge edge : edges) {
				int src = edge.source;
				int dest = edge.dest;

				adjList.get(src).add(dest);
				adjList.get(dest).add(src);
			}
		}
	}
}
