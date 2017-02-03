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

			if (2 == i && "B".equals(name)) {
				this.yield();
			}

			System.out.println(name + "运行  :  " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread1 th1 = new Thread1("A");
		Thread1 th2 = new Thread1("B");
		// th1.setPriority(2);
		// th2.setPriority(10);
		th1.start();
		System.out.println("th1 name==" + th1.name);
		th2.start();
		// for (int i = 0; i < 10; i++) {
		// System.out.println("i==" + i);
		//
		// }
		System.out.println("th2 name==" + th2.name);
	}
}


