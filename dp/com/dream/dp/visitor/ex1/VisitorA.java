package com.dream.dp.visitor.ex1;

public class VisitorA implements Visitor{

	/**
	 * 每个子访问对象控制对应子节点的方法访问
	 * 
	 * 访问每个节点提供不同的操作
	 */
	@Override
	public void visit(NodeA nodeA) {
		System.out.println(nodeA.operationA());
	}

	@Override
	public void visit(NodeB nodeB) {
		System.out.println(nodeB.operationB());
	}

}
