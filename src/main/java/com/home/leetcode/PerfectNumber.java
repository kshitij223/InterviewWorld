package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

	public static void main(String[] args) {
		int num=1000;

		List<Integer> ans = new ArrayList<>();
		int j=1;
		while(j<=num) {
			int sum=0;
			for(int i=1; i<=Math.sqrt(j); i++) {
				if(j%i==0) {
					if(i!=1) sum+=(i+j/i);
					else sum+=(i);
				}
			}	
			if(sum==j) ans.add(j);
			j++;
		}
		System.out.println(ans);
	}

}
