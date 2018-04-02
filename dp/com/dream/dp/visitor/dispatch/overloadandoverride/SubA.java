package com.dream.dp.visitor.dispatch.overloadandoverride;

public class SubA extends Super {
	public void operation(Super s) {
		System.out.println(" this is SubA.operation(Super s)");
	}
	
	public void operation(SubA s) {
		System.out.println(" this is SubA.operation(SubA s)");
	}
	
	public void operation(SubB s) {
		System.out.println(" this is SubA.operation(SubB s)");
	}
}
