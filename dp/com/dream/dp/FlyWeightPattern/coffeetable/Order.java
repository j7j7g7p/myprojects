package com.dream.dp.FlyWeightPattern.coffeetable;

public abstract class Order {
	abstract String getFlavor();
	
	abstract void serve(Table table);
}
