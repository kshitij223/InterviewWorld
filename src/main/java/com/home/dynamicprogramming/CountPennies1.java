package com.home.dynamicprogramming;

public class CountPennies1 {

	public static void main(String[] args) {
		System.out.println(makeChange(100, 25));
		//System.out.println(findWays(10));
	}
	
	public static int makeChange(int n, int denom) {
		int next_denom=0;
		switch(denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways=0;
		for (int i=0; i*denom <= n; i++) {
			ways += makeChange(n - i*denom, next_denom);
		}
		return ways;
	}
	
	public static int findWays(int n) {
		if (n==0) {
			return 1;
		}
		if (n<0) {
			return 0;
		}
		else {
			//return findWays(n-1) + findWays(n-5) + findWays(n-10) + findWays(n-25);
			return findWays(n-1) + findWays(n-3) + findWays(n-5);
		}
	}
}
