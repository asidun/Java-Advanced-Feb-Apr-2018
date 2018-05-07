package com.flowergarden.run.multithreading;

class Callme {
	void call(String msg) {
		System.out.println("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Прерывание");
		}
		System.out.println("]");
	}
}
