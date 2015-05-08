package com.home.graph;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyBFS {

	public void bfs (int[][] adj, int source) {
		int totalNodes = adj.length;
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] traversedNodes = new int[totalNodes];
		queue.add(source);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (traversedNodes[current] == 1) {
				continue;
			}
			System.out.println(current);
			traversedNodes[current] = 1;
			
			// Get adjacent nodes to current node.
			int[] adjTemp = adj[current];
			for (int i=0; i<adjTemp.length; i++) {
				if (adjTemp[i] == 1) {
					queue.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {
        int number_no_nodes, source;
        Scanner scanner = null;
 
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_no_nodes = scanner.nextInt();
 
            int adjacency_matrix[][] = new int[number_no_nodes][number_no_nodes];
            System.out.println("Enter the adjacency matrix");
            for (int i = 0; i < number_no_nodes; i++)
                for (int j = 0; j < number_no_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();
 
            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();
 
            System.out.println("The BFS traversal of the graph is ");
            MyBFS bfs = new MyBFS();
            bfs.bfs(adjacency_matrix, source);
 
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scanner.close();
    }

}
