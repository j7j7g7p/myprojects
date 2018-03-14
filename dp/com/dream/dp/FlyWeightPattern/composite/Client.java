package com.dream.dp.FlyWeightPattern.composite;

public class Client {
	public static void main(String[] args) {
		FlyWeightFactory factory = new FlyWeightFactory();
		FlyWeight fly = factory.factory("aba");
		fly.operate("hello world！");
	}
}
