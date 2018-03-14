package com.dream.dp.bridge.ex1.impl;

import com.dream.dp.bridge.ex1.Implementor;

public class ConcreteImplementorB extends Implementor {

	@Override
	public void operationImpl() {
		System.out.println("ConcreteImplementorB doing...");
	}

}
