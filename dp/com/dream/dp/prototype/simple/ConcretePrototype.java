package com.dream.dp.prototype.simple;

public class ConcretePrototype implements Prototype {
	
	public Prototype clone() {
		try {
			return (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
			return null;
		}
	}
	
}
