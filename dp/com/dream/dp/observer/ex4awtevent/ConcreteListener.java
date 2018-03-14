package com.dream.dp.observer.ex4awtevent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ConcreteListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getWhen());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
