package com.home.concurrency.prashant;

import java.util.UUID;

public class ProducerConsumerEnvironment {

	private static int producerThreads = 100;
	private static int consumerThreads = 100;
	private static int blockingQueueSize = 10;
	
	private static MonitorService monitorService;
	private static final BlockingQueue blockingQueue = new BlockingQueue(blockingQueueSize); 
	
	static {
		monitorService = new MonitorService();
		monitorService.setBlockingQueue(blockingQueue);
		monitorService.getMonitor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					monitorService.getStatus();
				} catch(Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		
		try {
			Producer producerThreadPool = new Producer(producerThreads);
			producerThreadPool.setBlockingQueue(blockingQueue);
			
			Consumer consumerThreadPool = new Consumer(consumerThreads);
			consumerThreadPool.setBlockingQueue(blockingQueue);
			
			while (true) {
				producerThreadPool.produce(UUID.randomUUID().toString());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				consumerThreadPool.consume();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
	}
}
