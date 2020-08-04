/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 *
 * @author Shivi Bhatt
 */
public class Homework9 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		System.out.println("-------Question 1 : Bellman Ford Algorithm Solution ----------------");
		int V = 5; // Number of vertices in graph
		int E = 8; // Number of edges in graph

		Q1BellmanFord graph = new Q1BellmanFord(V, E);

		// add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		graph.BellmanFord(graph, 0);

		System.out.println("----------Q2 Ford Fulkerson Algorithm Solution------");
		int graphFord[][] = new int[][] { { 0, 0, 6, 0, 0, 0 }, { 10, 0, 2, 0, 2, 0 }, { 4, 0, 0, 0, 5, 0 },
				{ 0, 4, 0, 0, 0, 6 }, { 0, 6, 4, 6, 0, 0 }, { 0, 0, 0, 4, 10, 0 } };
		Q2FordFulkerson m = new Q2FordFulkerson();
		System.out.println("The maximum possible flow is " + m.fordFulkerson(graphFord, 0, 5));

		System.out.println();
		System.out.println("--------Q6 Genetic Algorithm Solution ----------");
		Q6GeneticAlgorithm GA = new Q6GeneticAlgorithm();
		GA.run();
		System.out.println("-------- BalanceSpanningTree----------");
		BalanceSpanningTree balancedSpanningTree = new BalanceSpanningTree();
		balancedSpanningTree.run();
		
		/*
		 * Output for Q1, Q2, Q6: 
		 * -------Question 1 : Bellman Ford Algorithm Solution ----------------
Vertex Distance from Source
0		0
1		-1
2		2
3		-2
4		1
----------Q2 Ford Fulkerson Algorithm Solution------
The maximum possible flow is 5

--------Q6 Genetic Algorithm Solution ----------
Generation: 0 Fittest: 5

Solution found in generation 0
Fitness: 5
Genes: 11111
 Is Tree Balanced : true
 Is Tree Balanced : false

		 */
	}

}
