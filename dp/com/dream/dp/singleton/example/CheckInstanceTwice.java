package com.dream.dp.singleton.example;
/**
 * 当一个线程未经过同步获得实例然后调用方法时候，可能因为该对象还没有完成初始化而崩溃
 * @author 罗尚林
 *
 */

public class CheckInstanceTwice {

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			(new MyTask()).start();
		}
	}
}

class MyTask extends Thread {
	@Override
	public void run() {
		Helper.getHelper().printStr("我爱我家！");
	}
}