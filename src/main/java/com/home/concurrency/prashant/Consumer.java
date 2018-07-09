package com.home.concurrency.prashant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer {

	private static int MAX_THREADS = 100;
	private ExecutorService consumerThreadPool = null;
	private BlockingQueue blockingQueue = null;
	
	public Consumer() {
		this.consumerThreadPool = Executors.newFixedThreadPool(MAX_THREADS);
	}
	
	public Consumer(int threadCount) {
		if (threadCount < MAX_THREADS) {
			MAX_THREADS = threadCount;
		}
		this.consumerThreadPool = Executors.newFixedThreadPool(MAX_THREADS);
	}
	
	public void setBlockingQueue(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	public void consume() throws Exception {
		if (blockingQueue == null) {
			throw new Exception("No queue present!");
		}
		this.consumerThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Consuming " + blockingQueue.dequeue());
					Thread.sleep(1200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
