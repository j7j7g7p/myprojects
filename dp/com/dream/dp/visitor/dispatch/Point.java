package com.dream.dp.visitor.dispatch;

import java.awt.Canvas;

public class Point {
	int x,y;
	
	void draw(Canvas c) {
		System.out.println("Point draw()");
	}
	
	void oper(int a,int b) {
		
	}
	
	void oper(int a) {
		
	}
}
