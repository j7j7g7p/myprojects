package com.dream.dp.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

public class Enumerator implements Iterator{

	private Enumeration enumeration;
	public Enumerator(Enumeration enumeration){
		this.enumeration = enumeration;
	}
	
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
