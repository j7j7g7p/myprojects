package com.dream.dp.iterator.ex1;

public class PurchaseCopA extends Purchase {
	private Object[] objs = {
			"Monk Tang",
			"Monkey",
			"Pigsy",
			"Sandy",
			"Horse",
	};
	
	public PurchaseCopA() {
		
	}

	
	@Override
	public Iterator createtIterator() {
		return new ForwardIterator(this);
	}


	public int size() {
		return objs.length;
	}

	public Object getElement(int index) {
		if (index<=size()) {
			return objs[index];
		}
		return null;
	}

}


