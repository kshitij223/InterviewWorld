package com.home.multi;

class ThreadSample extends Thread
{
   private int startIdx, nThreads, maxIdx;

   public ThreadSample(int s, int n, int m)
   {
      this.startIdx = s;
      this.nThreads = n;
      this.maxIdx = m;
   }

   @Override
   public void run()
   {
      for(int i = this.startIdx; i < this.maxIdx; i += this.nThreads)
      {
         System.out.println("[ID " + this.getId() + "] " + i);
      }
   }
}

public class SampleThread {

	public static void func() {
		ThreadSample t1 = new ThreadSample(0, 3, 300);
		t1.start();
		for (int i=0; i<50000;i++) {
			
		}
		System.out.println("Created thread t1");
	}
	public static void main(String[] args) {
		func();
		System.out.println("Main thread closes");
	}
}
