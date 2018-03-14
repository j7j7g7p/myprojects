package com.dream.dp.FlyWeightPattern.composite;

import java.util.HashMap;
import java.util.Iterator;

public class CompositeConcreteFlyWeight extends FlyWeight {
	private HashMap<Character, FlyWeight> files = new HashMap<>();
	
	public CompositeConcreteFlyWeight() {
		
	}
	@Override
	public void operate(String state) {
		FlyWeight flyWeight = null;
		for(Iterator it=files.keySet().iterator();it.hasNext();) {
			Character key = (Character) it.next();
			if (files.containsKey(key)) {
				flyWeight = files.get(key);
				flyWeight.operate(state);
				System.out.println("合成模式享元模式外部状态："+state);
			}
		}
	}
	
	public void addFlyWeight(Character character,FlyWeight fly) {
		files.put(character, fly);
	}

}
