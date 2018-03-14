package com.dream.dp.factory.simplefactory;

public class Strawberry implements Fruit {


	@Override
	public void plant() {
		System.out.println("Strawberry plant...");
	}

	@Override
	public void grow() {
		System.out.println("Strawberry grow...");
	}

	@Override
	public void harvest() {
		System.out.println("Strawberry harvest...");
	}
	//辅助方法
	public static void log(String msg){
		System.out.println(msg);
	}

}
