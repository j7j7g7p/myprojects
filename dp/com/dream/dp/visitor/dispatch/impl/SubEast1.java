package com.dream.dp.visitor.dispatch.impl;

import com.dream.dp.visitor.dispatch.East;
import com.dream.dp.visitor.dispatch.West;

public class SubEast1 extends East {

	public void goEast(West west) {
		west.goWest1(this);
	}
	public String getName1() {
		return "SubEast1";
	}
}
