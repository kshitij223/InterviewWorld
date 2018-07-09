package com.home.graph;

import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class MyDFS {

	public static void main(String[] args) throws UnsupportedEncodingException {
		char c = 970;
		String s = new String(new char[]{c});
		System.out.println(s.length());
		System.out.println(s.toCharArray().length);
		System.out.println(s.getBytes("UTF-8").length);
		
		
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
            //dfs.dfs(adjacency_matrix, source);
            
            int[] visited = new int[adjacency_matrix.length];
            dfs.dfs(adjacency_matrix, source, visited);
 
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
	
	private void dfs(int[][] adjacency_matrix, int source, int[] visited) {
		int[] adjList = adjacency_matrix[source];
		visited[source]=1;
		System.out.println(source);
		for (int i=0; i<adjList.length; i++) {
			if (adjList[i]==1 && visited[i]==0) {
				dfs(adjacency_matrix, i, visited);
			}
		}
	}
	
	public String getSubString(String inputString, String subString) { 
		int maxOccurence = 0; 
		for (int i = 0; i < subString.length(); i++) { 
			char subStringChars = subString.charAt(i); 
			int charOccurence = inputString.indexOf(subStringChars); 
			if (charOccurence < 0) 
				return ""; 
			else if (charOccurence > maxOccurence) 
				maxOccurence = charOccurence; 
		} 
		return inputString.substring(0,maxOccurence+1); 
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
	
	public int[] multipleAllNumbers(int[] array) {
		int[][] storeTempResult = new int[array.length-1][array.length-1]; 
		int addedMultiple =1; 
		for(int i =0;i<array.length;i++){ 
			addedMultiple = addedMultiple*array[i]; 
			storeTempResult[0][i] = addedMultiple; 
		} 
		for(int i =array.length-1;i>=0;i--) { 
			addedMultiple = addedMultiple*array[i]; 
			storeTempResult[i][array.length-1] = addedMultiple; 
		} 
		for(int i =0;i<array.length;i++){ 
			array[i] = storeTempResult[0][i-1]*storeTempResult[i+1][array.length-1]; 
		} 
		return array; 
	}

}
