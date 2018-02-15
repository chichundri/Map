package com.test;

public class FooClassLock implements Runnable {
	@Override
	public void run() {
		Lock();
		m1();
	}

	public void m1() {
		System.out.println("m1 executed by "+Thread.currentThread().getName());
	}
	
	public void Lock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (FooClassLock.class) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		FooClassLock b1 = new FooClassLock();
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b1);
		FooClassLock b2 = new FooClassLock();
		Thread t3 = new Thread(b2);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}