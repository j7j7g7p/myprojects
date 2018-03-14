package com.dream.dp.factory.abstractfactory;

public class Factory1 extends AbstractFactory {

	@Override
	ProductA createProductA() {
		return new ProductA1();
	}

	@Override
	ProductB createProductB() {
		return new ProductB1();
	}

}
