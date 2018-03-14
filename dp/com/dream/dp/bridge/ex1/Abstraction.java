package com.dream.dp.bridge.ex1;

abstract public class Abstraction {
	
	protected Implementor impl;
	
	public void operation() {
		impl.operationImpl();
	}
}
