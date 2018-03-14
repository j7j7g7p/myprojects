package com.dream.dp.factory.simplefactory;

public class FruitGardenner {
	public static Fruit factory(String fruit) throws BadFruitException {
		if ("apple".equalsIgnoreCase(fruit)) {
			return new Apple();
		}else if ("grape".equalsIgnoreCase(fruit)) {
			return new Grape();
		}else if ("strawberry".equalsIgnoreCase(fruit)) {
			return new Strawberry();
		}else {
			throw new BadFruitException("please input right fruit we can grow..");
		}
	}
}
