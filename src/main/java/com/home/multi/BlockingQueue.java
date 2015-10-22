package com.home.multi;

import java.util.LinkedList;
import java.util.Queue;

class Producer extends Thread {
	Queue<Integer> queue = null;
	public void run() {
		System.out.println("I am writing data to the queue");
		while(true) {
			if (queue.size() == 3) {
				synchronized (queue) {
					while (queue.size() == 3) {
						System.out.println("Looks like queue is full");
						try {
							System.out.println("Waiting for queue to be empty");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

			for (int i=0; i<3; i++) {
				if (queue.size()<3) {
					synchronized (queue) {
						if (queue.size()<3) {
							queue.offer(i);
						}
					}
				} else {
					// Majority of the threads will come here.
				}
			}
			System.out.println("Produced items");
			synchronized (queue) {
				queue.notifyAll();
			}

		}
	}
}

class Consumer extends Thread {
	Queue<Integer> queue = null;
	public void run() {
		while(true) {
			if (queue.isEmpty()) {
				synchronized (queue) {
					try {
						while (queue.isEmpty()) {
							System.out.println("Waiting for queue to have items ");
							queue.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (!queue.isEmpty()) {
				synchronized (queue) {
					if (!queue.isEmpty()) {
						System.out.println("Just consumed " + queue.remove());
					}
				}
			}
			
			synchronized (queue) {
				queue.notifyAll();
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
