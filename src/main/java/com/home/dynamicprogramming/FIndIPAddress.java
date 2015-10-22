package com.home.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class FIndIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> IPAddresses = makeIPAddresses("123333", 1);
		System.out.println(IPAddresses);
	}

	private static List<String> makeIPAddresses(String str, int count) {
		if (str==null || str.isEmpty()) {
			return null;
		}
		
		List<String> answer = new ArrayList<>();
		if (count==4) {
			if (Integer.parseInt(str)>255) {
				return null;
			} else {
				answer.add(str);
				return answer;
			}
		}
		
		for (int i=0; i<str.length(); i++) {
			int toConsider = Integer.parseInt(str.substring(0, i+1));
			if (toConsider>255) {
				return answer;
			} else {
				List<String> partialIPList = makeIPAddresses(str.substring(i+1), count+1);
				if (partialIPList == null || partialIPList.isEmpty()) {
					continue;
				}
				for (String partialIP: partialIPList) {
					answer.add(toConsider+"."+partialIP);
				}
			}
		}
		return answer;
		
	}
}
