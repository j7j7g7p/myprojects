package com.dream.dp.observer.ex4awtevent;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

public class ConceretSubject extends Frame {

	public ConceretSubject() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public ConceretSubject(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public ConceretSubject(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ConceretSubject(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ConceretSubject subject = new ConceretSubject();
		ConcreteListener listener = new ConcreteListener();
		subject.setBounds(100, 100, 100, 100);
		subject.addMouseListener(listener);
		subject.show();
	}
}
