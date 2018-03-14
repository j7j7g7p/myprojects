package com.dream.dp.singleton.example;

import java.awt.Toolkit;

/**
 * Toolkit抽象类,单例懒汉
 * Abstract Window Toolkit 实际实现的抽象超类。Toolkit 的子类被用于将各种组件绑定到特定本机工具包实现。
 * 私有构造子是推迟到子类实现的剩余逻辑
 * @author 罗尚林
 *
 */
public class ToolkitTest {
	public static void main(String[] args) {
		/**
		 * 完全单例，不完全单例(默认单例模式-构造子没有私有化-选择交给客户端不可取)
		 */
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
	}
}
