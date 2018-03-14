package com.dream.dp.observer.ex6Swing;

import java.applet.Applet;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.Timer;

/**
 * 
 * @author thinkpad
 *
 */
public class RotatingCusorCompact extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RotatingCusorCompact() throws HeadlessException {
	}
	
	private Action updateCursorAction = new Action() {
		int ind = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ind==0) {
				drawCursor(Cursor.NE_RESIZE_CURSOR);
			}else if (ind==1) {
				drawCursor(Cursor.N_RESIZE_CURSOR);				
			}else if (ind==2) {
				drawCursor(Cursor.NW_RESIZE_CURSOR);
			}else if (ind==3) {
				drawCursor(Cursor.W_RESIZE_CURSOR);
			}else if (ind==4) {
				drawCursor(Cursor.SW_RESIZE_CURSOR);
			}else if (ind==5) {
				drawCursor(Cursor.S_RESIZE_CURSOR);
			}else if (ind==6) {
				drawCursor(Cursor.SE_RESIZE_CURSOR);
			}else if (ind==7) {
				drawCursor(Cursor.E_RESIZE_CURSOR);
				ind=-1;
			}
			ind++;
			
		}
		
		@Override
		public void setEnabled(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removePropertyChangeListener(PropertyChangeListener listener) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void putValue(String key, Object value) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Object getValue(String key) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void addPropertyChangeListener(PropertyChangeListener listener) {
			// TODO Auto-generated method stub
			
		}
		
		public void drawCursor(int cursorType) {
			setCursor(Cursor.getPredefinedCursor(cursorType));
		}
		
		public void init() {
			(new Timer(300, updateCursorAction)).start();
		}
	};

}
