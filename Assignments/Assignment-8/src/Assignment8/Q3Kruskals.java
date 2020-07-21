package Assignment8;
import java.util.Arrays;

//Shivi Bhatt : 001027605
public class Q3Kruskals {

	/**
	 * @param args the command line arguments
	 */
	class Edge implements Comparable<Edge> {

		int source, destination, edgeWeight;

		public int compareTo(Edge compareEdge) {
			return this.edgeWeight - compareEdge.edgeWeight;
		}
	};

	class subset {

		int parent, rank;
	};

	int V, E;
	Edge edge[];

	Q3Kruskals(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i) {
			edge[i] = new Edge();
		}
	}

	int find(subset subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}

		return subsets[i].parent;
	}

	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	void KruskalMST() {
		Edge result[] = new Edge[V];
		int e = 0;
		int i = 0;
		for (i = 0; i < V; ++i) {
			result[i] = new Edge();
		}

		Arrays.sort(edge);
		subset subsets[] = new subset[V];
		for (i = 0; i < V; ++i) {
			subsets[i] = new subset();
		}

		for (int v = 0; v < V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0;
		while (e < V - 1) {
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.source);
			int y = find(subsets, next_edge.destination);

			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}

		}

		System.out.println("Edges in Minimum Spanning Tree");
		for (i = 0; i < e; ++i) {
			System.out.println(result[i].source + " -- " + result[i].destination + " ==> " + result[i].edgeWeight);
		}
	}

	public static void main(String[] args) {
		int V = 6;
		int E = 11;

		System.out.println("Question 3: c) KRUSKAL'S Algorithm");
		Q3Kruskals graph = new Q3Kruskals(V, E);

		graph.edge[0].source = 0;
		graph.edge[0].destination = 1;
		graph.edge[0].edgeWeight = 53;

		graph.edge[1].source = 0;
		graph.edge[1].destination = 5;
		graph.edge[1].edgeWeight = 55;

		graph.edge[2].source = 1;
		graph.edge[2].destination = 5;
		graph.edge[2].edgeWeight = 70;

		graph.edge[3].source = 1;
		graph.edge[3].destination = 2;
		graph.edge[3].edgeWeight = 47;

		graph.edge[4].source = 5;
		graph.edge[4].destination = 2;
		graph.edge[4].edgeWeight = 68;

		graph.edge[5].source = 5;
		graph.edge[5].destination = 3;
		graph.edge[5].edgeWeight = 32;

		graph.edge[6].source = 5;
		graph.edge[6].destination = 4;
		graph.edge[6].edgeWeight = 37;

		graph.edge[7].source = 4;
		graph.edge[7].destination = 2;
		graph.edge[7].edgeWeight = 21;

		graph.edge[8].source = 4;
		graph.edge[8].destination = 3;
		graph.edge[8].edgeWeight = 56;

		graph.edge[9].source = 3;
		graph.edge[9].destination = 2;
		graph.edge[9].edgeWeight = 45;

		graph.KruskalMST();
	}

}
