package com.dream.dp.visitor.dispatch.impl;

import com.dream.dp.visitor.dispatch.West;

public class SubWest2 extends West {

	public void goWest1(SubEast1 east) {
		System.out.println("SubWest2 +" +east.getName1());
	}
	
	public void goWest2(SubEast2 east) {
		System.out.println("SubWest2 +" +east.getName2());
	}

}
