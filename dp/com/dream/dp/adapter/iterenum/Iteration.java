package com.dream.dp.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

public class Iteration implements Enumeration{
	private Iterator it;
	
	public Iteration(Iterator it){
		this.it = it;
	}
	
	@Override
	public boolean hasMoreElements() {
		return it.hasNext();
	}

	@Override
	public Object nextElement() {
		return it.next();
	}

}
