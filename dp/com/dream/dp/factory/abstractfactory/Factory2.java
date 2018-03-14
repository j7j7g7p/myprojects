package com.dream.dp.factory.abstractfactory;

public class Factory2 extends AbstractFactory {

	@Override
	ProductA createProductA() {
		return new ProductA2();
	}

	@Override
	ProductB createProductB() {
		return new ProductB2();
	}

}
