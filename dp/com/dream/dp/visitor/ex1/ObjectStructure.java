package com.dream.dp.visitor.ex1;

import java.util.Enumeration;
import java.util.Vector;

public class ObjectStructure {
	private Vector nodes;
	private Node node;
	/**
	 * Constructor
	 */
	public ObjectStructure() {
		nodes = new Vector<>();
	}
	
	/**
	 * 执行访问操作
	 */
	public void action(Visitor visitor) {
		for (Enumeration e = nodes.elements();e.hasMoreElements();) {
			node = (Node) e.nextElement();
			node.accept(visitor);
		}
	}
	
	/**
	 * 增加一个新的元素
	 */
	public void addNode(Node node) {
		nodes.addElement(node);
	}
}
