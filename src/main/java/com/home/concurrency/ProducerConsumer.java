package com.home.concurrency;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
	
	private static final BlockingQueue blockingQueue = new BlockingQueue();
	
	static {
		final MonitoringThread monitoringThread = new MonitoringThread();
		monitoringThread.getMonitor().execute(new Runnable() {
			public void run() {
				monitoringThread.reportStatus(blockingQueue);
			}
		});
	}
	
	public static void main(String[] args) throws InterruptedException {
		final int POOL_SIZE = 10;
		ExecutorService producerPool = Executors.newFixedThreadPool(POOL_SIZE);
		ExecutorService consumerPool = Executors.newFixedThreadPool(POOL_SIZE);

		while (true) {
			producerPool.execute(new Runnable() {

				@Override
				public void run() {
					try {
						String randomString = UUID.randomUUID().toString();
						System.out.println("Enqueuing " + randomString);
						blockingQueue.enqueue(randomString);
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			consumerPool.execute(new Runnable() {

				public void run() {
					try {
						System.out.println("Dequeuing " + blockingQueue.dequeue());
						Thread.sleep(1200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});

			//producerPool.shutdown();
			//consumerPool.shutdown();
		}
	}
}
