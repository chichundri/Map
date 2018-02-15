package com.test;

public class FooObjectLock implements Runnable {

	@Override
	public void run() {
		try {
			Lock();
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void m1() {
		System.out.println("m1 executed by " + Thread.currentThread().getName());
	}

	public void Lock() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		FooObjectLock b1 = new FooObjectLock();
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b1);
		FooObjectLock b2 = new FooObjectLock();
		Thread t3 = new Thread(b2);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}