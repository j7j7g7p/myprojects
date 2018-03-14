package com.dream.dp.factory.simplefactory;

public class Apple implements Fruit {
	private int treeAge;
	
	public int getTreeAge() {
		return treeAge;
	}

	public void setTreeAge(int treeAge) {
		this.treeAge = treeAge;
	}

	@Override
	public void plant() {
		System.out.println("apple plant...");
	}

	@Override
	public void grow() {
		System.out.println("apple grow...");
	}

	@Override
	public void harvest() {
		System.out.println("apple grow...");
	}
	
	//辅助方法
	public static void log(String msg){
		System.out.println(msg);
	}

}
