package com.dream.dp.proxy.reflect;

import java.lang.reflect.Method;

import javax.xml.ws.Action;

public class VectorProxy2{
	
	@Action
	public void testAnnotation() throws Exception {
		getParam1();
		getParam2();
	}
	
	public static void  common() throws Exception {
		  
		  String clazz = Thread.currentThread() .getStackTrace()[3].getClassName();
		  System.out.println(clazz);
		  String method = Thread.currentThread() .getStackTrace()[3].getMethodName();
		  System.out.println(method);
		  Method m = Class.forName(clazz).getMethod(method, null);
		  Action actioin = m.getAnnotation(Action.class);
		  System.out.println(actioin.output());
	}
	
	public static void  getParam1() throws Exception {
		  
		common();
	}
	public static void getParam2() throws Exception {
		
		  String clazz = Thread.currentThread() .getStackTrace()[2].getClassName();
		  System.out.println(clazz);
		  String method = Thread.currentThread() .getStackTrace()[2].getMethodName();
		  System.out.println(method);
		  Method m = Class.forName(clazz).getMethod(method, null);
		  Action actioin = m.getAnnotation(Action.class);
		  System.out.println(actioin.output());
	}
}
