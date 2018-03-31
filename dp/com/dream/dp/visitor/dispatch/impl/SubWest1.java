package com.dream.dp.visitor.dispatch.impl;

import com.dream.dp.visitor.dispatch.West;

public class SubWest1 extends West {

	@Override
	public void goWest1(SubEast1 east) {
		System.out.println("SubWest1 +" +east.getName1());
	}
	
	public void goWest2(SubEast2 east) {
		System.out.println("SubWest1 +" +east.getName2());
	}
}
