package com.dream.dp.singleton.impl;

public class RegSingletonChild extends RegSingleton{
	
	//父类通过反射的方式提供实例，构造子必须是公开的 -缺点1
	public RegSingletonChild(){}
	
	//必须有父类实例才能有子类实例-缺点2
	public static RegSingletonChild getInstance() {
		return (RegSingletonChild) getInsatance(RegSingletonChild.class.getName());
	}
	public static void main(String[] args) {
		System.out.println(RegSingletonChild.class.getName());//com.dream.dp.singleton.RegSingletonChild
		System.out.println(RegSingletonChild.getInsatance("com.dream.dp.singleton.RegSingletonChild") ==
				RegSingletonChild.getInsatance("com.dream.dp.singleton.RegSingletonChild"));
		System.out.println(RegSingletonChild.getInstance() == RegSingletonChild.getInstance());
		RegSingletonChild regSingletonChild = new RegSingletonChild();
	}
}
