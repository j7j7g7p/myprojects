package com.dream.dp.FlyWeightPattern.composite;

import java.util.HashMap;

public class FlyWeightFactory {
	private HashMap<Character ,FlyWeight> files = new HashMap<>();
	
	public FlyWeightFactory() {
	}
	public FlyWeight factory(Character character) {
		if (files.containsKey(character)) {
			return (FlyWeight) files.get(character);
		}else {
			FlyWeight conceret = new ConcreteFlyWeight(character);
			files.put(character, conceret);
			return conceret;
		}
	}
	
	public FlyWeight factory(String state) {
		CompositeConcreteFlyWeight compositeConcreteFlyWeight = new CompositeConcreteFlyWeight();
		for (int i = 0; i < state.length(); i++) {
			Character character = new Character(state.charAt(i));
			System.out.println("factory("+state+")");
			compositeConcreteFlyWeight.addFlyWeight(character, this.factory(character));
		}
		return compositeConcreteFlyWeight;
	}
}
