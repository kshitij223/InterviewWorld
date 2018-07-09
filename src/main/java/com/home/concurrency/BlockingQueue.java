package com.home.concurrency;

import java.util.LinkedList;
import java.util.List;


public class BlockingQueue {
	
	private static int MAX_SIZE = 10;
	private List<String> queue;
	
	public BlockingQueue() {
		queue = new LinkedList<String>();
	}
	
	public synchronized void enqueue(String string) throws InterruptedException {
		if (!string.isEmpty()) {
			while (queue.size() == MAX_SIZE) {
				wait();
				System.out.println("waiting while enqueing");
			}
			if (queue.size() == 0) {
				notifyAll();
				System.out.println("notifying: Enq");
			}
			queue.add(string);
		}
	}
	
	public synchronized String dequeue() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
			System.out.println("waiting while dequeing");
		}
		if (queue.size() >= MAX_SIZE) {
			notifyAll();
			System.out.println("notifying: DEq");
		}
		return queue.remove(0);
	}
	
	public int getSize() {
		return queue.size();
	}
	
}
