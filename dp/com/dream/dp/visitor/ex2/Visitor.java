package com.dream.dp.visitor.ex2;

/**
 * 访问者为每个节点创建一个访问入口
 */
public interface Visitor {
	
	void visitHardDisc(HardDisc e);
	
	void visitMainBoard(MainBoard e);
	
	void visitCpu(Cpu e);
	
	void visitPc(Pc e);
	
	void visitCase(Case e);
	
	void visitIntegreteBoard(IntegreteBoard e);
}
