package com.real;

import java.util.LinkedList;

public class IsBipartieGraph {
	public static int V = 4;

	// This function returns true if graph
	// G[V][V] is Bipartite, else false
	public static boolean isBipartiteUtil(int G[][], int src, int colorArr[]) {
		colorArr[src] = 1;

		// Create a queue (FIFO) of vertex numbers and
		// enqueue source vertex for BFS traversal
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);

		// Run while there are vertices in queue
		// (Similar to BFS)
		while (!q.isEmpty()) {
			// Dequeue a vertex from queue
			// ( Refer http://goo.gl/35oz8 )
			int u = q.getFirst();
			q.pop();

			// Return false if there is a self-loop
			if (G[u][u] == 1)
				return false;

			// Find all non-colored adjacent vertices
			for (int v = 0; v < V; ++v) {
				// An edge from u to v exists and
				// destination v is not colored
				if (G[u][v] == 1 && colorArr[v] == -1) {
					// Assign alternate color to this
					// adjacent v of u
					colorArr[v] = 1 - colorArr[u];
					q.push(v);
				}

				// An edge from u to v exists and
				// destination v is colored with same
				// color as u
				else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
					return false;
			}
		}

		// If we reach here, then all adjacent vertices
		// can be colored with alternate color
		return true;
	}

	// Returns true if G[][] is Bipartite, else false
	public static boolean isBipartite(int G[][]) {
		// Create a color array to store colors assigned
		// to all veritces. Vertex/ number is used as
		// index in this array. The value '-1' of
		// colorArr[i] is used to indicate that no color
		// is assigned to vertex 'i'. The value 1 is used
		// to indicate first color is assigned and value
		// 0 indicates second color is assigned.
		int colorArr[] = new int[V];
		for (int i = 0; i < V; ++i)
			colorArr[i] = -1;

		// This code is to handle disconnected graoh
		for (int i = 0; i < V; i++)
			if (colorArr[i] == -1)
				if (isBipartiteUtil(G, i, colorArr) == false)
					return false;

		return true;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int G[][] = {
				{ 0, 1, 0, 1 },
				{ 1, 0, 1, 0 },
				{ 0, 1, 0, 1 }, 
				{ 1, 0, 1, 0 } };

		if (isBipartite(G))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
