package com.dream.dp.singleton.example;

public class Helper {

	private static Helper helper;

	public void printStr(String str) {
		System.out.println("print：" + str);
	}
	
	public static Helper getHelper() {
		if (helper == null) {
			synchronized (CheckInstanceTwice.class) {
				if (helper == null) {
					return new Helper();
				}
			}
		}
		return helper;
	}
}
