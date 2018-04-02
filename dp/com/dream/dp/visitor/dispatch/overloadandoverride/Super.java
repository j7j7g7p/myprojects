package com.dream.dp.visitor.dispatch.overloadandoverride;

public class Super {
	public void operation(Super s) {
		System.out.println(" this is Super.operation(Super s)");
		s.operation(this);
	}
}
