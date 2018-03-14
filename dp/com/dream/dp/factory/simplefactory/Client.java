package com.dream.dp.factory.simplefactory;

import java.text.DateFormat;
import java.util.Date;

public class Client {
	public static void main(String[] args) {
		try {
			Apple apple = (Apple) FruitGardenner.factory("apple");
			Grape grape = (Grape) FruitGardenner.factory("grape");
			Strawberry strawberry = (Strawberry) FruitGardenner
					.factory("strawberry");
			apple.grow();
			grape.grow();
			strawberry.grow();
		} catch (BadFruitException e) {
			e.printStackTrace();
		}
		
		//工厂角色和抽象角色合并典型的是java.text.DateFormat
		//提供抽象类中获得提供实例的方法
		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateInstance();
		
		DateFormat dateFormat = DateFormat.getDateInstance(0);
		String format = dateFormat.format(date);
		System.out.println(format);
	}
}
