package Assignment7;

import java.util.Iterator;
import java.util.LinkedList;

public class Q2DFS {

	// no of vertices.
	int V;

	// we are building graph using adjacency list.
	// so we should have linked list for every node and store adjacent nodes of that
	// node in that list
	LinkedList<Integer> adjList[];

	// constructor
	Q2DFS(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adjList[i] = new LinkedList(); // it will create empty list for every node
		}
	}

	// adding edges to graph
	void addEdgesToGraph(int v, int u) {
		adjList[v].add(u); // here it will add vertex to adjacency list of another vertex so that edge can
							// be added to graph.
	}

	// depth first traversal is used by depth first search. it will traverse one
	// strong component completely
	void DFTraversal(int v, int visited[]) {
		visited[v] = 1;
		System.out.print(v + " ");
		Iterator<Integer> i = adjList[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (visited[n] == 0)
				DFTraversal(n, visited);
		}
	}

	// depth first search will call depth fist traversal on disconnected components.
	// it will keep track of visited[] array.
	void DFSearch(int v) {

		int visited[] = new int[V];

		DFTraversal(v, visited);
		for (int i = 1; i < V; i++) {
			if (visited[i] == 0) {
				DFTraversal(i, visited);
			}
		}
	}

	public static void main(String args[]) {
		Q2DFS obj = new Q2DFS(10);

		obj.addEdgesToGraph(1, 4);
		obj.addEdgesToGraph(5, 6);
		obj.addEdgesToGraph(4, 6);
		obj.addEdgesToGraph(3, 7);
		obj.addEdgesToGraph(6, 7);
		obj.addEdgesToGraph(5, 7);
		obj.addEdgesToGraph(2, 4);
		obj.addEdgesToGraph(2, 3);
		obj.addEdgesToGraph(4, 7);
		obj.addEdgesToGraph(4, 8);
		obj.addEdgesToGraph(5, 9);

		// For Directed Graph Ques
//		obj.addEdgesToGraph(0, 1);
//		obj.addEdgesToGraph(0, 4);
//		obj.addEdgesToGraph(0, 3);
//		obj.addEdgesToGraph(1, 2);
//		obj.addEdgesToGraph(1, 4);
//		obj.addEdgesToGraph(2, 5);
//		obj.addEdgesToGraph(3, 4);
//		obj.addEdgesToGraph(3, 6);
//		obj.addEdgesToGraph(4, 7);
//		obj.addEdgesToGraph(4, 5);
//		obj.addEdgesToGraph(6, 4);
//
//		obj.addEdgesToGraph(6, 7);
//		obj.addEdgesToGraph(7, 5);
//		obj.addEdgesToGraph(7, 8);

		// This is for reversing edges in undirected graph
		obj.addEdgesToGraph(4, 1);
		obj.addEdgesToGraph(6, 5);
		obj.addEdgesToGraph(6, 4);
		obj.addEdgesToGraph(7, 3);
		obj.addEdgesToGraph(7, 6);
		obj.addEdgesToGraph(7, 5);
		obj.addEdgesToGraph(4, 2);
		obj.addEdgesToGraph(3, 2);
		obj.addEdgesToGraph(7, 4);
		obj.addEdgesToGraph(8, 4);
		obj.addEdgesToGraph(9, 5);

		obj.DFSearch(1);
	}
}
