package com.home.callable;

import java.util.concurrent.Callable;

public class CallableTest {

	public static void main(String[] args) throws Exception {
		Callable helper = helper();
		System.out.println(helper.call());
	}

	private static Callable helper() throws Exception {
		// TODO Auto-generated method stub
		final String s = "abc";
		Callable c = new Callable() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return s+"def";
			}
		};
		return c;
	}

}
