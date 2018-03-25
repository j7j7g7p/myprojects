package com.dream.dp.iterator.ex;

public class Client {
	public static void main(String[] args) {
		ConcreteAggregate aggregate  = new ConcreteAggregate();
		Iterator iterator = aggregate.createtIterator();
		while(!iterator.isDone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
//		System.out.println(aggregate.getElement(0));
		System.out.println("==========================");
		ConcreteAggregate2 aggregate2  = new ConcreteAggregate2();
		iterator = aggregate2.createtIterator();
		while(!iterator.isDone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
	}

}
