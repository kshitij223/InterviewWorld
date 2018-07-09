package com.home.concurrency.prashant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer {
	
	private static int MAX_THREADS = 100;
	private ExecutorService producerThreadPool = null;
	private BlockingQueue blockingQueue = null;
	
	public Producer() {
		this.producerThreadPool = Executors.newFixedThreadPool(MAX_THREADS);
	}
	
	public Producer(int threadCount) {
		if (threadCount < MAX_THREADS) {
			MAX_THREADS = threadCount;
		}
		this.producerThreadPool = Executors.newFixedThreadPool(MAX_THREADS);
	}
	
	public void setBlockingQueue(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	public void produce(final Object object) throws Exception {
		if (blockingQueue == null) {
			throw new Exception("No queue present!");
		}
		this.producerThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Producing " + (String) object);
				try {
					blockingQueue.enqueue(object);
					//Thread.sleep(600);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
