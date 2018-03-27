package com.dream.dp.memo.enhance;

public class Caretaker {
	private Memento memento;
	private Originator originator;

	public Caretaker(Originator originator) {
		this.originator = originator;
		setMemento(originator.createMemento());
	}
	/**
	 * @return the memento
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * @param memento the memento to set
	 */
	public void setMemento(Memento memento) {
		this.memento = memento;
	}

	/**
	 * 增强负责人，封装发起人恢复的工作
	 */
	public void restoreMemo(int index) {
		originator.restoreMemento(memento,index);
	}
}
