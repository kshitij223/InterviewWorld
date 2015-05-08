package com.home.miscellaneous;

public class StringCompression {

	public static void main(String[] args) {
		String test="a";
		int newLength = processStr(test);
		System.out.println(newLength);
	}

	private static int processStr(String test) {
		int length=0;
		int count=1;
		char[] testArr = test.toCharArray();
		int base=0;
		for (int i=1; i<testArr.length; i++) {
			if(testArr[i] == testArr[base]) {
				count++;
			} else {
				length+=1+Integer.toString(count).length();
				base=i;
				count=1;
			}
		}
		length+=1+Integer.toString(count).length();
		return length;
	}
}
