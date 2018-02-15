package com.test;

public class ThreadA {

	public static void main(String[] args) throws InterruptedException {
		ThreadB threadB = new ThreadB();
		threadB.start();
		synchronized (threadB) {
			System.out.println("main thread call wait() method");
			threadB.wait();
			System.out.println("main thread got notification call");
		}
		System.out.println("Total: "+threadB.total);
	}
}

class ThreadB extends Thread {
	int total=0;
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("Child thread started calculation");
			for (int i = 0; i < 10; i++) {
				total+=i;
			}
			System.out.println("Child thread giving notification");
			notify();
		}
	}
}
