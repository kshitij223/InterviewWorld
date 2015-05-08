package com.home.multi;

class ThreadSample extends Thread
{
	private int startIdx, nThreads, maxIdx;
	private String string;
	private int var = 4;

	public ThreadSample(String string) {
		this.string = string;
	}

	@Override
	public void run()
	{
		for (int i=0; i<10;i++) {
			{
				System.out.println(string + " is printing " + var);
				var ++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("[ID " + this.getId() + "] " + i);
			}
		}
	}
}

public class SampleThread {

	public static void func() {
		ThreadSample t1 = new ThreadSample("First");
		t1.start();
		ThreadSample t2 = new ThreadSample("Second");
		t2.start();
	}
	public static void main(String[] args) {
		func();
	}
}
