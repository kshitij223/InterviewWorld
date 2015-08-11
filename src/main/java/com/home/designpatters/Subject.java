package com.home.designpatters;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	List<Observer> allObservers = new ArrayList<>();
	int state;
	
	public void setState(int state) {
		this.state = state;
		notifyObservers();
	}
	
	public void attach(Observer ob) {
		allObservers.add(ob);
	}
	
	public void notifyObservers() {
		for (Observer obs: allObservers) {
			obs.update();
		}
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Thing> basket = new ArrayList<Thing>();  
		Thing thing = new Thing(100);  
		basket.add(thing);  
		Thing another = new Thing(100);  
		boolean b = basket.contains(another); // true or false?
		System.out.println(b);
	}
}


class Thing {

	int i;
	public Thing(int i) {
		this.i=i;
	}
	
	@Override
	public boolean equals(Object o) {
		if ((o instanceof Thing) && ((Thing)o).i == i) {
			return true;
		}
		return false;
	}
	
}
