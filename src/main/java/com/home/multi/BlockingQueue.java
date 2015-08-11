package com.home.multi;

import java.util.LinkedList;
import java.util.Queue;

class Producer extends Thread {
	Queue<Integer> queue = null;
	public void run() {
		System.out.println("I am writing data to the queue");
		while(true) {
			synchronized (queue) {
				while (queue.size() == 3) {
					try {
						System.out.println("Waiting for queue to be empty");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i=0; i<3; i++) {
					if (queue.size()<3) {
						queue.offer(i);
					}
				}
				System.out.println("Produced items");
				queue.notify();
			}
		}
	}
}

class Consumer extends Thread {
	Queue<Integer> queue = null;
	public void run() {
		while(true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Waiting for queue to have items");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (!queue.isEmpty()) {
					queue.remove();
				}
				System.out.println("Consumed items");
				queue.notify();
			}
		}
	}
}

public class BlockingQueue {

	private static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Producer prod = new Producer();
		prod.queue = queue;

		Consumer cons = new Consumer();
		cons.queue = queue;

		prod.start();
		cons.start();

	}

}
