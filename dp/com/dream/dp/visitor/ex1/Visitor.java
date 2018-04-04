package com.dream.dp.visitor.ex1;

/**
 * 访问者为每个节点创建一个访问入口
 * @author A170227
 *
 */
public interface Visitor {
	public void visit(NodeA node);
	public void visit(NodeB node);
}
