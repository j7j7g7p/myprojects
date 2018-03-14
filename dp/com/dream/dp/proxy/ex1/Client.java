package com.dream.dp.proxy.ex1;

public class Client {
	public static void main(String[] args) {
		ProxySubject subject = new ProxySubject();
		subject.method();
	}
}
