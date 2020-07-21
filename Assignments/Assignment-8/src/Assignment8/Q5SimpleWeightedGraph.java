package Assignment8;

import java.util.HashSet;
import java.util.Set;

public class Q5SimpleWeightedGraph {

	/**
	 * Adjacency Matrix
	 */
	Integer[][] data;

	public Q5SimpleWeightedGraph(int vNumber) {
		data = new Integer[vNumber][vNumber];
	}

	public void addEdge(char s1, char s2) {
		addEdge(s1, s2, 1);
	}

	public void addEdge(char s1, char s2, int weight) {
		data[chToIdx(s1)][chToIdx(s2)] = weight;
	}

	public int getEdgeWeight(char a, char b) {
		return data[chToIdx(a)][chToIdx(b)];
	}

	public Set<Character> getAdj(char node) {
		HashSet<Character> result = new HashSet<Character>();

		Integer[] adjiacent = data[chToIdx(node)];
		for (int i = 0; i < adjiacent.length; i++) {
			if (adjiacent[i] != null)
				result.add(idxToChar(i));
		}

		return result;
	}

	private static char idxToChar(int i) {
		return (char) (i + 'a');
	}

	private static int chToIdx(char c) {
		return (char) (c - 'a');
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleWeightedGraph\n");
		for (int i = 0; i < data.length; i++) {
			sb.append("V=").append(idxToChar(i)).append(" -> Adj={");
			for (int j = 0; j < data.length; j++) {
				if (data[i][j] != null)
					sb.append("[").append(idxToChar(j)).append(",").append(data[i][j]).append("]");
			}
			sb.append("}\n");
		}
		System.out.println(sb);
	}

	public static Q5SimpleWeightedGraph getGraphInstance() {
		Q5SimpleWeightedGraph graph = new Q5SimpleWeightedGraph(7);

		graph.data[chToIdx('a')][chToIdx('b')] = 5;
		graph.data[chToIdx('a')][chToIdx('c')] = 3;
		graph.data[chToIdx('b')][chToIdx('c')] = 4;
		graph.data[chToIdx('b')][chToIdx('d')] = 6;
		graph.data[chToIdx('b')][chToIdx('e')] = 2;
		graph.data[chToIdx('c')][chToIdx('d')] = 5;
		graph.data[chToIdx('c')][chToIdx('f')] = 11;
		graph.data[chToIdx('d')][chToIdx('e')] = 7;
		graph.data[chToIdx('d')][chToIdx('f')] = 9;
		graph.data[chToIdx('e')][chToIdx('f')] = 12;
		graph.data[chToIdx('e')][chToIdx('g')] = 8;
		graph.data[chToIdx('g')][chToIdx('f')] = 7;

		graph.data[chToIdx('b')][chToIdx('a')] = 5;
		graph.data[chToIdx('c')][chToIdx('a')] = 3;
		graph.data[chToIdx('c')][chToIdx('b')] = 4;
		graph.data[chToIdx('d')][chToIdx('b')] = 6;
		graph.data[chToIdx('e')][chToIdx('b')] = 2;
		graph.data[chToIdx('d')][chToIdx('c')] = 5;
		graph.data[chToIdx('f')][chToIdx('c')] = 11;
		graph.data[chToIdx('e')][chToIdx('d')] = 7;
		graph.data[chToIdx('f')][chToIdx('d')] = 9;
		graph.data[chToIdx('f')][chToIdx('e')] = 12;
		graph.data[chToIdx('g')][chToIdx('e')] = 8;
		graph.data[chToIdx('f')][chToIdx('g')] = 7;
		return graph;
	}

}