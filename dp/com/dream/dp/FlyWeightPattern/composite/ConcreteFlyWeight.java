package com.dream.dp.FlyWeightPattern.composite;

public class ConcreteFlyWeight extends FlyWeight {
	private Character innerstate = null;
	public ConcreteFlyWeight(Character innerstate) {
		this.innerstate = innerstate;
	}
	
	@Override
	public void operate(String state) {
		System.out.println("享元对象实体类外部状态："+state);
	}

}
