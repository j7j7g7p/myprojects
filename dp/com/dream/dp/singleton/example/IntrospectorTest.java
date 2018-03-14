package com.dream.dp.singleton.example;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
/**
 * 自省类Introspector
 * 静态代码块工厂
 * @author 罗尚林
 *
 */
public class IntrospectorTest {
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(AppConfig.class);
		System.out.println(beanInfo.getDefaultEventIndex());
	}
}
