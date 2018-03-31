package com.dream.dp.visitor.dispatch;

import com.dream.dp.visitor.dispatch.impl.SubEast1;
import com.dream.dp.visitor.dispatch.impl.SubWest1;
import com.dream.dp.visitor.dispatch.impl.SubWest2;

/**
 */
public class DoubleTest {
	public static void main(String[] args) {
		East east = new SubEast1();
		West west = new SubWest1();
		West west2 = new SubWest2();
		east.goEast(west);
		east.goEast(west2);
	}
}
