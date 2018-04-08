package com.dream.dp.interpreter;

/**
 * 定义的抽象表达式，所有表达式继承该类
 * 表达式分为终结表达式和非终结表达式
 * @author thinkpad
 *
 */
public abstract class Expresstion {
	
	/**
	 * 解释给定的任何表达式
	 * @param context
	 * @return
	 */
	public abstract boolean interpret(Context context);
	
	/**
	 * 验证表达式在结构上是否相等
	 */
	public abstract boolean equals(Object o);
	
	/**
	 * 返回表达式的额哈希值
	 * @return
	 */
	public abstract int hashcode();
	
	/**
	 * 表达式转换成字符
	 */
	public abstract String toString();
}
