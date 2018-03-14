package com.dream.dp.FlyWeightPattern.sample;

public class Client {
	public static void main(String[] args) {
		FlyWeightFactory factory = new FlyWeightFactory();
		FlyWeight fly = factory.factory('a');
		fly.operate("first time");
		FlyWeight fly2 = factory.factory('b');
		fly2.operate("second time");
		FlyWeight fly3 = factory.factory('a');
		fly3.operate("third time");
		System.out.println(fly == fly3);
	}
}
