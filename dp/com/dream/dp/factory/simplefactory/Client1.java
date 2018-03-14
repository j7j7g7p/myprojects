package com.dream.dp.factory.simplefactory;

public class Client1{
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		for(int i=1;i<=100000;i++){
			Join.getInstance();
		}
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		
		long d = System.currentTimeMillis();
		for(int i=1;i<=100000;i++){
			new Join();
		}
		long f = System.currentTimeMillis();
		System.out.println(f-d);
	}
}
