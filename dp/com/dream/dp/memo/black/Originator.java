package com.dream.dp.memo.black;

/**
 * 发起人角色
 * @author thinkpad
 *
 */
public class Originator {
	private String state;
	
	public Originator() {
		
	}
	
	/**
	 * 工厂方法，创建备忘录角色
	 * @return
	 */
	public MementoIF createMemento() {
		return new Memento(state);
	}
	
	/**
	 * 还原发起人的状态
	 * @param memento
	 */
	public void restoreMemento(MementoIF memento) {
		Memento memeo = (Memento)memento;//向下转型 将窄接口转为宽接口
		this.state = memeo.getState();
		System.out.println("Current state:"+state);
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
		System.out.println("Current state:"+state);
	}
	
	public class Memento implements MementoIF{
		private String state;
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}
		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * Constructor
		 * @param state
		 */
		public Memento(String state) {
			this.state = state;
		}
	}
	
}
