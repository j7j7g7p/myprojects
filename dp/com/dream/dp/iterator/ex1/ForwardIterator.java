package com.dream.dp.iterator.ex1;

public class ForwardIterator implements Iterator {
	private Purchase aggregate;
	private int index = 0;
	private int size = 0;
	
	public ForwardIterator(Purchase aggregate) {
		this.aggregate = aggregate;
		this.size = aggregate.count();
		index = 0;
	}

	@Override
	public void first() {
		index = 0;
	}

	@Override
	public void next() {
		if (index<size) {
			index++;
		}
	}

	@Override
	public boolean isDone() {
		return (index>=size);
	}

	@Override
	public Object currentItem() {
		return aggregate.get(index);
	}

}
