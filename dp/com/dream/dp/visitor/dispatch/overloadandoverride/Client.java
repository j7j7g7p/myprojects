package com.dream.dp.visitor.dispatch.overloadandoverride;

public class Client {
	public static void main(String[] args) {
		Super s = new SubA();
		Super s2 = new SubB();
		s.operation(s2);
		// this is SubA.operation(Super s)
	}
}

