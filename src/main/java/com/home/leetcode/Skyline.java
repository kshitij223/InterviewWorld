package com.home.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Skyline {

	public static void main(String[] args) {
		int[][] skyline = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		List<int[]> skyline2 = new Skyline().getSkyline(skyline);

		for(int[] arr: skyline2) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+",");
			}
			System.out.println();
		}

	}

	public List<int[]> getSkyline(int[][] buildings) {
		if(buildings==null || buildings.length==0) return null;

		List<int[]> points = new ArrayList<>();
		List<int[]> passiveBldg = new ArrayList<>();
		int[] activeBldg=null;

		//find min and max Xs
		int minX = buildings[0][1];
		int maxX = buildings[buildings.length-1][1];

		int i=minX, buildingIndex=0;
		activeBldg=buildings[buildingIndex];
		int[] ansPart = {buildings[buildingIndex][0], buildings[buildingIndex][2]};
		points.add(ansPart);
		i=buildings[buildingIndex][0];
		buildingIndex++;

		boolean isBaren=false;
		while(i<=maxX && buildingIndex<buildings.length) {
			//remove active if that building has ended
			if(activeBldg!=null && activeBldg[1]<i) {
				activeBldg=null;
				//Go back one index
				i--;
			}

			//Cleanup the passive list
			List<Integer> toBeRemoved = new ArrayList<>();
			for(int j=0; j<passiveBldg.size(); j++) {
				if (i>passiveBldg.get(j)[1]) {
					toBeRemoved.add(j);
				}
			}
			for(Integer r: toBeRemoved) passiveBldg.remove((int)r);


			//if we encounter a new building starting at this location:
			if(buildings[buildingIndex][0] == i) {
				//If its taller than current, mark this as active, else add in passive
				if(activeBldg==null || activeBldg[2]<buildings[buildingIndex][2]) {
					if(activeBldg!=null) passiveBldg.add(activeBldg);
					activeBldg = buildings[buildingIndex];
					int[] ansPart2 = {buildings[buildingIndex][0], buildings[buildingIndex][2]};
					points.add(ansPart2);
					isBaren=false;
				} else {
					passiveBldg.add(buildings[buildingIndex]);
				}

				buildingIndex++;
			} else if (activeBldg==null && passiveBldg.isEmpty() && !isBaren) {
				//This would happen when there are no active buidlings/empty landscape
				int[] ansPart2 = {i, 0};
				points.add(ansPart2);
				isBaren=true;
			} else if (activeBldg==null && !passiveBldg.isEmpty()) {
				//nominate a building from passive list and mark as active
				int tallest=0;
				for(int j=1; j<passiveBldg.size(); j++) {
					if(passiveBldg.get(j)[2]>passiveBldg.get(tallest)[2]) {
						tallest=j;
					}
				}
				//Use current X axis but the building's height.
				int[] ansPart2 = {i, passiveBldg.get(tallest)[2]};
				points.add(ansPart2);
				activeBldg=passiveBldg.get(tallest);
				passiveBldg.remove(tallest);

			}
			i++;
		}

		//Add last marker
		int[] ansPart2 = {maxX, 0};
		points.add(ansPart2);
		return points;   
	}

	
}
