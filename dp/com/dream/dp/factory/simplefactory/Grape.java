package com.dream.dp.factory.simplefactory;

public class Grape implements Fruit {
	private boolean idSeed;
	
	public boolean isIdSeed() {
		return idSeed;
	}

	public void setIdSeed(boolean idSeed) {
		this.idSeed = idSeed;
	}

	@Override
	public void plant() {
		System.out.println("Grape plant...");
	}

	@Override
	public void grow() {
		System.out.println("Grape grow...");
	}

	@Override
	public void harvest() {
		System.out.println("Grape harvest...");
	}
	//辅助方法
	public static void log(String msg){
		System.out.println(msg);
	}

}
