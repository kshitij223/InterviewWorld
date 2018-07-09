package com.home.concurrency.prashant;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private static int MAX_SIZE = 100;
	private List<Object> blockingQueue;

	public BlockingQueue() {
		this.blockingQueue = new LinkedList<Object>();
	}

	public BlockingQueue(int size) {
		if (size < MAX_SIZE) {
			MAX_SIZE = size;
		}
		this.blockingQueue = new LinkedList<Object>();
	}

	public synchronized void enqueue(Object object) throws InterruptedException {
		while (this.blockingQueue.size() == MAX_SIZE) {
			System.out.println("************ ENQUEUE WAIT ***********");
			wait();
		}

		if (this.blockingQueue.size() == 0) {
			System.out.println("************ ENQUEUE NOTIFY ALL ***********");
			notifyAll();
		}

		this.blockingQueue.add(object);
		System.out.println("[ENQUEUE] " + (String) object);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.blockingQueue.size() == 0) {
			System.out.println("************ DEQUEUE WAIT ***********");
			wait();
		}

		if (this.blockingQueue.size() >= MAX_SIZE) {
			System.out.println("************ DEQUEUE NOTIFY ALL ***********");
			notifyAll();
		}

		System.out.println("[DEQUEUE] " + (String) this.blockingQueue.get(0));
		return this.blockingQueue.remove(0);
	}

	public int size() {
		return this.blockingQueue.size();
	}

}
