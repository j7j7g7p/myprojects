package com.dream.dp.visitor.dispatch;

/**
 * 1,静态分配 -- 编译过程中 -- 重载
 * 2,动态分派 -- 运行时期
 * 
 * 方法的调用时根据对象的真实类型而不是静态类型
 * 
 * 分派表
 * @author A170227
 *
 */
public class Test {
	public static void main(String[] args) {
		String a = "ab";
		Object object = a+"c";
		String b = "abc";
		System.out.println(object.equals(b));
		
		Point p1 = new Point();
		Point p2 = new ColorPoint();
		//静态多分派
		p1.oper(1);
		p1.oper(1,2);
		//动态单分派
		p1.draw(null);
		p2.draw(null);
	}
}
