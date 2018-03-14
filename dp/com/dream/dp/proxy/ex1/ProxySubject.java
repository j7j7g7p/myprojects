package com.dream.dp.proxy.ex1;

public class ProxySubject extends Subject{
	private RealSubject realSubject;

	@Override
	void method() {
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		System.out.println("before...");
		realSubject.method();
		System.out.println("after...");
	}
}
