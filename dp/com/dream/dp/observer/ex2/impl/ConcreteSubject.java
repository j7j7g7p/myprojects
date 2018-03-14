package com.dream.dp.observer.ex2.impl;

import com.dream.dp.observer.ex1.impl.ConcreteObservicer;
import com.dream.dp.observer.ex2.Subject;

public class ConcreteSubject extends Subject{
	private String state;
	
	public void change(String newstate) {
		state = newstate;
		this.notifyObserver();
	}

	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		subject.attach(new ConcreteObservicer());
		subject.change("newstate");
	}
}
