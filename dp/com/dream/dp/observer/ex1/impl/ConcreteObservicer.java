package com.dream.dp.observer.ex1.impl;

import com.dream.dp.observer.ex1.Observer;

public class ConcreteObservicer implements Observer {

	@Override
	public void update() {
		System.out.println("udate...");
	}

}
