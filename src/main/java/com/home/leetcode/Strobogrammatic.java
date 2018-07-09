package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic {

	public static void main(String[] args) {
		System.out.println(new Strobogrammatic().findStrobogrammatic(4));
	}

	char[] chars = {'0','1','6','8','9'};
	public List<String> findStrobogrammatic(int n) {
		if (n<=0) return null;
		List<String> result = new ArrayList<>();

		boolean isOdd = (n%2==1);
		char[] ans=new char[n];
		findNumbers(0, n, isOdd, result, ans);

		return result;
	}

	private void findNumbers(int i, int n, boolean isOdd, List<String> result, char[] ans) {
		if (i==n/2 && !isOdd) {
			result.add(new String(ans));
			return;
		}

		if (i==n/2) {
			ans[i]=chars[0];
			result.add(new String(ans));

			ans[i]=chars[1];
			result.add(new String(ans));

			ans[i]=chars[3];
			result.add(new String(ans));
			return;
		}


		for (int x=0; x<chars.length; x++) {
			if(i==0 && x==0) {
				continue;
			} else {
				ans[i]=chars[x];
				if(x==2) {
					ans[n-i-1] = chars[4];
				} else if (x==4) {
					ans[n-i-1] = chars[2];
				} else {
					ans[n-i-1]=chars[x];
				}

				findNumbers(i+1, n, isOdd, result, ans);
			}
		}
	}
}
