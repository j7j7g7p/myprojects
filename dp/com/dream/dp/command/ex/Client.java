package com.dream.dp.command.ex;

/**
 * 命令模式是对命令的封装
 * 命令的发布者之和命令打交道不和命令的执行者接触
 * 本质是命令的发布者和命令的接受者之间的分层管理
 * @author A170227
 *
 */
public class Client {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker(command);//发布命令
		invoker.action();
	}
}
