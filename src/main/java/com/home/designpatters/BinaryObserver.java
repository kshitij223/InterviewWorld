package com.home.designpatters;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject s) {
		this.sub = s;
	}
	@Override
	public void update() {
		System.out.println(Integer.toBinaryString(this.sub.state));
		
	}
	
	public static void main(String[] args) {
		Subject s = new Subject();
		s.attach(new BinaryObserver(s));
		s.state = 5;
		s.notifyObservers();
	}

}
