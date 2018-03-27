package com.dream.dp.memo.historyItself;

/**
 * 黑箱实现，发起人返回窄接口
 * 交于负责人给与外界
 * 自述历史备忘模式 
 * 优点：简单易懂
 * 缺点：每个发起人就是一个责任人，当需要多个责任人共享发起人的时候就无法做到
 * @author thinkpad
 *
 */
public class Client {
	private static Originator originator = new Originator();

	public static void main(String[] args) {
		//改变发起人的状态
		originator.setState("on");
		//创建备忘录对象，并将发起人的状态保存起来
		MementoIF createMemento = originator.createMemento();//暴露给外界的是窄接口
		//改变发起人的状态
		originator.setState("off");
		//恢复发起人的状态
		originator.restoreMemento(createMemento);
	}
	
	
}
