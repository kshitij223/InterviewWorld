package com.home.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LockerProblem {

	public static void main(String[] args) {
		createKey();
		

		//		digits[0] = 0;
		//	    backtrack(2, 0);
		//return 0;
	}

	private static String createKey() {
		Set<String> keySet = new HashSet<>();
		genKeys(0, keySet, "");
		try {
		return createKeyHelper(keySet, "00");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("HI");
		}
		return null;
	}

	private static void genKeys(int depth, Set<String> keyMap, String str) {
		if(depth==3) {
			keyMap.add(str);
			return;
		}

		for(int i=0; i<=9; i++) {
			genKeys(depth+1, keyMap, str+i);
		}
	}

	// 00133456789
	private static String createKeyHelper(Set<String> keySet, String str) {

		if(keySet.isEmpty()) {
			System.out.println(str);
			System.out.println(str.length());
			return null;
		}

		String base=str.charAt(str.length()-2) + "" + str.charAt(str.length()-1);
		for (int i=0;i<=9;i++) {
			if(keySet.contains(base+i)) {
				keySet.remove(base+i);
				createKeyHelper(keySet, str+i);
				if(!keySet.isEmpty()) {
					keySet.add(base+i);
				} else {
					break;
				}
			}
		}
		return null;
	}

	static boolean used[] = new boolean [1000];
	static int digits[] = new int[33333];

	static boolean backtrack(int index, int total)
	{
		if (total == 1000)
		{
			System.out.println(index);
			for (int i = 0; i < index; ++i) {
				System.out.print(digits[i]);
			}
			System.out.println();
			return true;
		}

		for (int d = 0; d < 10; ++d)
		{
			int prev = 100*digits[index-2]+10*digits[index-1]+d;
			if (!used[prev]) {
				digits[index] = d;
				used[prev] = true;
				if (backtrack(index+1, total+1))
					return true;
				used[prev] = false;
			}
		}
		return false;
	}


}
