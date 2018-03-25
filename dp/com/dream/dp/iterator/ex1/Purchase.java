package com.dream.dp.iterator.ex1;

import java.util.Vector;

public abstract class Purchase {
	private Vector elements = new Vector<>();
	
	public Iterator createtIterator() {
		return null;
	}
	
	public void add(Object obj) {
		elements.addElement(obj);
	}
	
	public void remove(Object obj) {
		elements.remove(obj);
	}
	
	public Object get(int index) {
		return elements.elementAt(index);
	}
	
	public int count() {
		return elements.size();
	}
}
