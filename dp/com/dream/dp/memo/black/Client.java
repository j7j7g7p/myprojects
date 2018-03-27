package com.dream.dp.memo.black;

/**
 * 黑箱实现，发起人返回窄接口
 * 交于负责人给与外界
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
		MementoIF createMemento = originator.createMemento();//暴露给外界的是窄接口
		caretaker.setMemento(createMemento);
		//改变发起人的状态
		originator.setState("off");
		//恢复发起人的状态
		originator.restoreMemento(caretaker.getMemento());
	}
	
	
}
