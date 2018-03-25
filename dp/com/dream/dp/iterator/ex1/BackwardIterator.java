package com.dream.dp.iterator.ex1;

public class BackwardIterator implements Iterator {
	private Purchase aggregate;
	private int index = 0;
	private int size = 0;
	
	public BackwardIterator(Purchase aggregate) {
		this.aggregate = aggregate;
		this.size = aggregate.count();
		index = this.size-1;
	}

	@Override
	public void first() {
		index = 0;
	}

	@Override
	public void next() {
		if (index>=0) {
			index--;
		}
	}

	@Override
	public boolean isDone() {
		return (index<0);
	}

	@Override
	public Object currentItem() {
		return aggregate.get(index);
	}
}
