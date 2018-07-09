package com.home.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MonitoringThread {
	private ExecutorService monitor;

	public MonitoringThread() {
		monitor = Executors.newSingleThreadExecutor();
	}

	public ExecutorService getMonitor() {
		if (monitor == null) {
			monitor = Executors.newSingleThreadExecutor();
		}
		return monitor;
	}

	public void reportStatus(BlockingQueue blockingQueue) {
		while(true) {
			try {
				System.out.println("\n[MONITOR] The queue size is " + blockingQueue.getSize());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
