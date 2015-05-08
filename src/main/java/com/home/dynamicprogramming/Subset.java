package com.home.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Subset {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(createSets(list, list.size()));
	}

	private static List<List<Integer>> createSets(List<Integer> list, int index) {
		if (index == 0) {
			List<List<Integer>> l = new ArrayList<>(1);
			l.add(new ArrayList<Integer>());
			return l;
		}
		List<List<Integer>> ansList = createSets(list, index-1);
		int newElement = list.get(index-1);
		List<List<Integer>> compositeList = new ArrayList();
		List<List<Integer>> dummyCompositeList = new ArrayList();
		compositeList.addAll(ansList);
		dummyCompositeList.addAll(ansList);
		for (List<Integer> partList : dummyCompositeList) {
			List<Integer> temp = new ArrayList<>(partList);
			temp.add(newElement);
			compositeList.add(temp);
		}
		return compositeList;
	}

}
