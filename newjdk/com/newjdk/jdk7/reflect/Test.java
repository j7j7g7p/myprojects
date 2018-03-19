package com.newjdk.jdk7.reflect;

public class Test {
	public static void main(String[] args) {
		//反射时候只需要抛出反射操作异常 即可 ：ReflectiveOperationException
		Class<?> clazz;
		try {
			clazz = Class.forName("com.biezhi.apple.User");
			clazz.getMethods()[0].invoke("");
		} catch (ReflectiveOperationException e) {//@since 1.7
			e.printStackTrace();
		}
	}
}
