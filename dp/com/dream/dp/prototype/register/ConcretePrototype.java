package com.dream.dp.prototype.register;

public class ConcretePrototype implements Prototype {
	
	public synchronized Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone(); 
			return prototype;
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}finally{
			return prototype;
		}
	}
	
}
