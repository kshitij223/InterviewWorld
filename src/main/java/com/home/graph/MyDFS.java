package com.home.graph;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class MyDFS {

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
 
            System.out.println("The DFS traversal of the graph is ");
            MyDFS dfs = new MyDFS();
            dfs.dfs(adjacency_matrix, source);
 
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scanner.close();
    }

	private void dfs(int[][] adjacency_matrix, int source) {
		Stack<Integer> currentState = new Stack<>();
		int[] visited = new int[adjacency_matrix.length];
		currentState.push(source);
		visited[source]=1;
		System.out.println(currentState.peek());
		
		while(!currentState.isEmpty()) {
			int neighbor = getUnvisitedNode(adjacency_matrix, currentState.peek(), visited);
			if (neighbor == -1) {
				// pop.
				currentState.pop();
			} else {
				currentState.push(neighbor);
				visited[neighbor]=1;
				System.out.println(neighbor);
				
			}
		}
		
	}

	private int getUnvisitedNode(int[][] adjacency_matrix, int source,
			int[] visited) {
		int[] myNeighbors = adjacency_matrix[source];
		for (int i =0; i<myNeighbors.length; i++) {
			if (myNeighbors[i]==1 &&
					visited[i]==0) {
				return i;
			}
		}
		return -1;
	}

}
