package com.dream.dp.decorator;

public class Decorator implements Component
{
	private Component component = null;
	
	public Decorator(Component component) {
		this.component = component;
	}
	@Override
	public void commonMethod() {
		component.commonMethod();
	}
	
	public void addMethod() {
		System.out.println(123);
	}
}
