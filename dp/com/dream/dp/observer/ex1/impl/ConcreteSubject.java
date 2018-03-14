package com.dream.dp.observer.ex1.impl;

import java.util.Enumeration;
import java.util.Vector;

import com.dream.dp.observer.ex1.Observer;
import com.dream.dp.observer.ex1.Subject;

public class ConcreteSubject implements Subject {
	private Vector observersVector = new Vector<>();
	
	@Override
	public void attach(Observer observer) {
		observersVector.addElement(observer);
	}

	@Override
	public void detach(Observer observer) {
		observersVector.remove(observer);
	}

	@Override
	public void notifyObserver() {
		Enumeration observers = observers();
		while (observers.hasMoreElements()) {
			((Observer) observers.nextElement()).update();
		}
	}
	
	public Enumeration observers() {
		return ((Vector)observersVector.clone()).elements();
	}

}
