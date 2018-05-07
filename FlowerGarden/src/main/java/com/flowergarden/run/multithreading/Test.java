package com.flowergarden.run.multithreading;

class Test {
	public static void main(String args[]) {
		Callme target = new Callme();
		Caller obj1 = new Caller(target, "Привет");
		Caller obj2 = new Caller(target, "Синхронизированный");
		Caller obj3 = new Caller(target, "Мир");
		try {
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Прерывание");
		}
	}
}
