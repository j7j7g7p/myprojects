package com.dream.dp.interpreter;

import java.util.HashMap;

/**
 * 解释器模式：类的行为模式
 * 给定一种语言，解释器模式可以定义出其文法的的一种表示，并同时提供一个解释器，客户端使用这个解释器解释这个语言的句子
 * 针对某一类问题经常发生，将此类问题的各个实例表达为简单语言的语句
 */
public class Context {
	private HashMap map = new HashMap<>();
	
	public void assign(Variable var,boolean value) {
		map.put(var, value);
	}
	
	public boolean lookup(Variable var) throws IllegalArgumentException{
		Boolean value = (Boolean)map.get(var);
		if (value==null) {
			throw new IllegalArgumentException();
		}
		return value;
	}
}
