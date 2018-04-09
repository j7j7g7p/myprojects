package com.dream.dp.mediator;

/**
 * 调停着模式
 * @author thinkpad
 *
 */
public class Test {
	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		mediator.createCollegue();
		Collegue1 c1 = new Collegue1(mediator);
		mediator.colleagueChanged(c1);
	}
}
