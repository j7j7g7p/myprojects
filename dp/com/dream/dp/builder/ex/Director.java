package com.dream.dp.builder.ex;

public class Director {
	private Builder builder;
	
	public Builder contructor(){
		builder = new ConcreteBuilder();
		builder.builderPart1();
		builder.builderPart2();
		return builder;
//		builder.retrieveResult();
	}
}
