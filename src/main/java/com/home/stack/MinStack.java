package com.home.stack;

import java.util.Stack;

public class MinStack {

	static Stack<Integer> mainStack = new Stack<Integer>();
	static Stack<Integer> lowStack = new Stack<Integer>();
	public static void main(String[] args) {
		

	}
	
	private static void push(Integer ele) {
		int min = Integer.MAX_VALUE;
		if (!lowStack.isEmpty()) {
			min = lowStack.peek();
		}
		if (min > ele) {
			lowStack.push(ele);
		}
		mainStack.push(ele);
	}
	
	private static Integer pop() {
		int ele = mainStack.pop();
		if (ele == lowStack.peek()) {
			lowStack.pop();
		}
		return ele;
	}
	
	private static Integer findMin() {
		return lowStack.peek();
	}
}
