package com.dream.dp.visitor.ex1;

/**
 * 通常用来处理比较复杂的对象数结构
 * 可以处理跨越多个等级的树结构问题
 * 如果系统的结构是频繁变化的就不适合使用访问者模式
 * 倾斜的可扩展设计：方法集合的可扩展行和类的不可扩展性
 * @author A170227
 * 访问者对象是对变化的封装
 */
public class Client {
	private static ObjectStructure ob;
	private static Visitor visitor;
	public static void main(String[] args) {
		//创建一个结构对象
		ob = new ObjectStructure();
		//添加节点
		ob.addNode(new NodeA());
		ob.addNode(new NodeB());
		//创建一个新的访问者
		visitor = new VisitorA();
		//访问者访问结构
		ob.action(visitor);
	}
}
