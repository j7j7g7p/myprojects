package com.dream.dp.iterator.ex1;

public class Client {
	public static void main(String[] args) {
		Purchase aggregate  = new PurchaseCopB();
		aggregate.add("airconditioner");
		aggregate.add("airconditioner2");
		aggregate.add("airconditioner3");
		aggregate.add("airconditioner4");
		Iterator iterator = aggregate.createtIterator();
		while(!iterator.isDone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
	}

}
