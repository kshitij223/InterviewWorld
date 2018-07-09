package com.home.concurrency.prashant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MonitorService {
	
	private ExecutorService monitor;
	private BlockingQueue blockingQueue;
	
	public MonitorService() {
		this.monitor = Executors.newSingleThreadExecutor();
	}
	
	public void setBlockingQueue(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	public ExecutorService getMonitor() {
		return this.monitor;
	}

	public void getStatus() throws Exception {
		if (this.blockingQueue == null) {
			throw new Exception("No queue present!");
		}
		while(true) {
			System.out.println("\n**** [MONITOR] Current queue size is: " + this.blockingQueue.size() + "****\n");
			Thread.sleep(500);
		}
	}
}
