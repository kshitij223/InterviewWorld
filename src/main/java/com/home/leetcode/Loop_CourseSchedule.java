package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Loop_CourseSchedule {

	public static void main(String[] args) {
		
		int[][] prereq = {{0,2},{1,2},{2,0}};
		System.out.println(new Loop_CourseSchedule().canFinish(3, prereq));

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || numCourses<=0) return false;
        //if(numCourses!=prerequisites.length) return false;
            
        boolean[] visited = new boolean[numCourses];
        
        //Build adjacency list
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int j=0;
        while (j<numCourses) {
        	adjList.add(new ArrayList<>());
        	j++;
        }
        for(int i=0; i<prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i=0; i<numCourses; i++) {
        	boolean[] recurse = new boolean[numCourses];
             if(isLoop(adjList, i, recurse, visited)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isLoop(List<List<Integer>> adjList, int node, boolean[] recurse, boolean[] visited) {
    	if(adjList.size()<=node) return false;
        if(recurse[node]) return true;
        
        recurse[node] = true;
        boolean res = false;
        if(!visited[node]) {
            if (!adjList.get(node).isEmpty()) {
            	for(Integer nieghbors: adjList.get(node)) {
            		res = isLoop(adjList, nieghbors, recurse, visited);
            	}
            }
            visited[node] = true;
        }
        return res;
    }
}
