package com.dream.dp.visitor.dispatch.impl;

import com.dream.dp.visitor.dispatch.East;
import com.dream.dp.visitor.dispatch.West;

public class SubEast2 extends East {

	public void goEast(West west) {
		west.goWest2(this);
	}
	public String getName2() {
		return "SubEast2";
	}
}
