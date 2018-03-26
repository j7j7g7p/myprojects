package com.dream.dp.memo.white;

/**
 * 白箱实现，简单但破坏对发起人状态的封装
 * @author thinkpad
 *
 */
public class Client {
	private static Originator originator = new Originator();
	private static Caretaker caretaker =  new Caretaker();

	public static void main(String[] args) {
		//改变发起人的状态
		originator.setState("on");
		//创建备忘录对象，并将发起人的状态保存起来
		caretaker.setMemento(originator.createMemento());
		//改变发起人的状态
		originator.setState("off");
		//恢复发起人的状态
		originator.restoreMemento(caretaker.getMemento());
	}
	
	
}
