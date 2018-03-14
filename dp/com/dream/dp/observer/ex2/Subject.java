package com.dream.dp.observer.ex2;

import java.util.Enumeration;
import java.util.Vector;

import com.dream.dp.observer.ex1.Observer;

abstract public class Subject {

private Vector observersVector = new Vector<>();
	
	public void attach(Observer observer) {
		observersVector.addElement(observer);
	}

	public void detach(Observer observer) {
		observersVector.remove(observer);
	}

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
