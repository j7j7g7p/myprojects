package com.dream.dp.visitor.ex2;

public abstract class Equipment {
	public abstract void accept(Visitor vi);
	
	public abstract double price();
}
