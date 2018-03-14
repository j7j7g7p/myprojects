package com.dream.dp.decorator;

public class Client {
	public static void main(String[] args) {
		//全透明面向抽象编程,调用接口方法
		Component concerete = new Concrete();
		Component component = new Decorator(concerete);
		//半透明，可以调用独有方法
		Component concerete2 = new Concrete();
		Decorator component2 = new Decorator(concerete);
	}
}
