package com.dream.dp.FlyWeightPattern.sample;

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
}
