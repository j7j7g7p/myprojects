package com.dream.dp.iterator.ex;

public class ConcreteAggregate extends Aggregate {
	private Object[] objs = {
			"Monk Tang",
			"Monkey",
			"Pigsy",
			"Sandy",
			"Horse",
	};
	
	public ConcreteAggregate() {
		
	}

	
	@Override
	public Iterator createtIterator() {
		return new ConcreteIterator(this);
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


