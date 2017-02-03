package com.makerspace.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现Runnable接口的run方法
 * 
 * @author 李关钦
 * @version 2017年2月3日
 */
public class Thread2 implements Runnable {
	private String name;

	public Thread2(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 5; i++) {
			System.out.println(sdf.format(new Date()) + "    " + name + ";" + Thread.currentThread().getName() + "运行    ：   " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		Thread th1 = new Thread(new Thread2("th1"));
		Thread th2 = new Thread(new Thread2("th2"));
		th2.setPriority(10);
		// th1.yield();
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
	}

}

