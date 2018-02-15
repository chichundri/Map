package com.test;

public class FooClassLock implements Runnable {
	@Override
	public void run() {
		
		try {
			Lock();
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void m1() {
		System.out.println("m1 executed by "+Thread.currentThread().getName());
	}
	
	public void Lock() throws InterruptedException{
		System.out.println(Thread.currentThread().getName());
		synchronized (FooClassLock.class) {
			if(Thread.currentThread().getName().equals("t1")){
				System.out.println("t1 locked for 5000 ms");
				Thread.sleep(5000);
			}
			System.out.println("in block " + Thread.currentThread().getName());
//			Thread.sleep(5000);
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