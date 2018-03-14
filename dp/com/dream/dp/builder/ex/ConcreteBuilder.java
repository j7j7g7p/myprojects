package com.dream.dp.builder.ex;

public class ConcreteBuilder extends Builder {

	private Product product = new Product();
	
	@Override
	public void builderPart1() {
		//builderPart1
	}

	@Override
	public void builderPart2() {
		//builderPart2
	}

	@Override
	public Product retrieveResult() {
		return product;
	}

}
