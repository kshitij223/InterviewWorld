package com.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxVacations {

	public static Map<String, Integer> cache = new HashMap<>();
    public int maxVacationDays(int[][] flights, int[][] days) {
        return maxVacationDaysHelper(flights, days, 0, -1);
    }
    
    private int maxVacationDaysHelper(int[][] flights, int[][] days, int week, int currCity) {
    
        int max=-1;
        if (week<days[0].length) {
            for (int city=0; city<days[0].length; city++) {
               if(currCity==-1 || isFlightPresent(flights, currCity, city) || currCity == city) {
                    int vac=-1;
                    if (cache.containsKey((week+1)+"-"+city)) {
                        vac = days[city][week] + cache.get((week+1)+"-"+city);
                        if (vac>max) max=vac;
                    } else {
                        vac = days[city][week] + 
                        maxVacationDaysHelper(flights, days, week+1, city);
                        if (vac>max) {
                            max=vac;
                            cache.put((week + "-" + city), max);
                        }
                    }
                }
            }
        } else {
        	return 0;
        }
        return max;
    }
    
    private boolean isFlightPresent(int[][] flights, int src, int dest) {
        return flights[src][dest]==1?true:false;
    }
	
	public static void main(String[] args) {
		//int[][] flights = new int[][] {{0,1,1},{1,0,1},{1,1,0}};
		//int[][] days = new int[][] {{1,3,1},{6,0,3},{3,3,3}};
		
		int[][] flights = new int[][] {{0,0,0},{0,0,0},{0,0,0}}; 
		int[][] days = new int[][] {{1,1,1},{7,7,7},{7,7,7}};
				
		//System.out.println(days[0][2]);
		System.out.println(new MaxVacations().maxVacationDays(flights, days));
		//System.out.println(new MaxVacations().maxVacationDaysHelper(flights, days, 2, 2));

	}

}
