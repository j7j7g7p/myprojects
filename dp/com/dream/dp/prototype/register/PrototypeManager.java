package com.dream.dp.prototype.register;

import java.util.Vector;

public class PrototypeManager {
	private Vector<Prototype> vector = new Vector<Prototype>();
	
	public void add(Prototype prototype){
		vector.add(prototype);
	}
	public Prototype get(int i){
		return vector.get(i);
	}
	public  int getSize() {
		return vector.size();
	}
}
