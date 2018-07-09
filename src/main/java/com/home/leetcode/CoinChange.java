package com.home.leetcode;

import java.util.HashMap;


public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		//System.out.println(coinChange(coins, 11, new HashMap<Integer, Integer>()));
		System.out.println(makeChange(6, new int[]{25,10,5,1}));

	}
	
	public static int coinChange(int[] coins, int amount, HashMap<Integer, Integer> hashMap) {
		if(amount==0) return 0;
		if(hashMap.containsKey(amount)) return hashMap.get(amount);
		
		int ans=Integer.MAX_VALUE;
		for (int i=0;i<coins.length;i++) {
			if (amount-coins[i]>=0) {
				int temp = coinChange(coins, amount-coins[i], hashMap);
				if(temp==-1) continue;

				if(temp<ans) {
					ans = 1+temp;
				}
			}
		}

		if(ans==Integer.MAX_VALUE) ans=-1;
		hashMap.put(amount, ans);
		return ans==Integer.MAX_VALUE?-1:ans;
	}
	
	public static int makeChange(int sum, int[] coins) {
		
		if(sum<0) return 0;
		if(sum==0) return 1;
		
		int i=0, count=0;
		while (i<coins.length) {
			if(sum>=coins[i]) {
				count+=makeChange(sum-coins[i], coins);
			}
			i++;
		}
		
		return count;
	}

}
