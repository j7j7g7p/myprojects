package com.dream.dp.bridge.ex1.impl;

import com.dream.dp.bridge.ex1.Implementor;

public class ConcreteImplementorA extends Implementor {

	@Override
	public void operationImpl() {
		System.out.println("ConcreteImplementorA doing...");
	}

}
