package com.dream.dp.proxy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

import javax.xml.ws.Action;

public class VectorProxy implements InvocationHandler {
	
	private Object proxyObj;
	
	public VectorProxy(Object object) {
		this.proxyObj =object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("beford...");
		if (args!=null) {
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}
		Object o = method.invoke(proxy, args);
		System.out.println("after...");
		return o;
	}

	public static Object factory(Object object) {
		Class cls = object.getClass();
		//cls.getClassLoader(),cls.getInterfaces(),
//		cls.getClassLoader().loadClass(name)
		cls.getInterfaces();
		return new VectorProxy(object);
	}
	
	public static void main(String[] args) {
//		List v = null;
//		v = (List) factory(new Vector(10));
//		v.add("New");
//		v.add("York");
//		Class.forName("").getMethod("", String.class).getAnnotations()
		 VectorProxy oProxy = new VectorProxy(null);
		 try {
			oProxy.testAnnotation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Action
	public void testAnnotation() throws Exception {
		testAnnotation1();
		testAnnotation2();
	}
	
	@Action
	public void testAnnotation1() throws Exception {
		 VectorProxy2.getParam1();
		 VectorProxy2.getParam2();
	}
	public void testAnnotation2() throws Exception {
		
		  String clazz = Thread.currentThread() .getStackTrace()[2].getClassName();
		  System.out.println(clazz);
		  String method = Thread.currentThread() .getStackTrace()[2].getMethodName();
		  System.out.println(method);
		  Method m = Class.forName(clazz).getMethod(method, null);
		  Action actioin = m.getAnnotation(Action.class);
		  System.out.println(actioin.output());
	}
}
