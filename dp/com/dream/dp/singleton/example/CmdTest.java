package com.dream.dp.singleton.example;

import java.io.IOException;

/**
 * runtime是java的单例模式
 * 用途：执行外部命令、内存、gc、加载动态库
 * @author 罗尚林
 *
 */
public class CmdTest {
	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("notepad.exe");
		Process process1 = Runtime.getRuntime().exec("cmd/E:ON/c start MyDocument.doc");
	}
}
