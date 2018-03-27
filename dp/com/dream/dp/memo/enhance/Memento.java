package com.dream.dp.memo.enhance;

import java.util.Vector;

/**
 * 备忘录角色
 * @author thinkpad
 *
 */
public class Memento {
	private Vector<String> states;
	private int index=0;
	/**
	 * Constructor
	 * @param state
	 */
	public Memento(int index,Vector<String> states) {
		this.setIndex(index);
		this.states = (Vector<String>) states.clone();
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Vector<String> getStates() {
		return states;
	}

}
