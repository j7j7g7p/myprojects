package com.dream.dp.memo.enhance;

import java.util.Vector;

/**
 * 发起人角色
 * @author thinkpad
 *
 */
public class Originator {
	private Vector<String> states;
	private int index=0;
	
	public Originator() {
		this.states = new Vector<>();
		this.index=0;
	}
	
	/**
	 * 工厂方法，创建备忘录角色
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(index,states);
	}
	
	/**
	 * 还原发起人的状态
	 * @param memento
	 */
	public void restoreMemento(Memento memento,int index) {
		if (index>memento.getIndex()) {			
			this.index = memento.getIndex();
		}else {
			this.index = index;
		}
		this.states = memento.getStates();
		getInfo();
	}
	
	public void setState(int index ,String state) {
		this.index = index;
		this.states.add(index, state);
		getInfo();
	}
	public void getInfo() {
		System.out.println("Current index:"+index+"   Current state:"+states.get(index));
		System.out.println("All states:");
		for (int i =0;i<states.size();i++) {
			System.out.println("index:"+i+"  state:"+states.get(i));
		}
		System.out.println("\n");
	}
}
