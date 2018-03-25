package com.dream.dp.iterator.ex;

public class ConcreteAggregate2 extends Aggregate {
	private Object[] objs = {
			"Monk Tang",
			"Monkey",
			"Pigsy",
			"Sandy",
			"Horse",
	};
	
	public ConcreteAggregate2() {
		
	}

	
	@Override
	public Iterator createtIterator() {
		return (new ConcreteIterator2());
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
	
	public class ConcreteIterator2 implements Iterator{
		private int index = 0;
		
		public ConcreteIterator2() {
			this.index = 0;
		}
		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			if (index<size()) {
				index++;
			}
		}

		@Override
		public boolean isDone() {
			return (index>=size());
		}

		@Override
		public Object currentItem() {
			return getElement(index);
		}
	}
}


