package com.dream.dp.visitor.dispatch.overloadandoverride;

public class SubB extends Super {
	public void operation(Super s) {
		System.out.println(" this is SubB.operation(Super s)");
	}
	
	public void operation(SubA s) {
		System.out.println(" this is SubB.operation(SubA s)");
	}
	
	public void operation(SubB s) {
		System.out.println(" this is SubB.operation(SubB s)");
	}
}
