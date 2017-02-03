package com.makerspace.thread;

/**
 * 继承T和Thread类
 * 
 * @author 李关钦
 * @version 2017年2月3日
 */
public class Thread1 extends Thread {
	private String name;

	public Thread1(String name) {
		super();
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  :  " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();
	}
}


