package com.dream.dp.bridge.ex1.impl;

import com.dream.dp.bridge.ex1.Abstraction;

public class AbstractionImpl extends Abstraction {
	public AbstractionImpl() {
		this.impl = new ConcreteImplementorA();
	}
	
	
	@Override
	public void operation() {
		super.operation();
	}

	
}
