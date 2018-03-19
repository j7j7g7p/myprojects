package com.newjdk.jdk8.trytest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	
	public static void main(String[] args) {
		
	}
	
	//try-with-resources 只要实现 AutoCloseable try语句块退出的时候自动调用close 方法关闭流资源。
	public static void tryWithResources() throws IOException {
		 try( InputStream ins = new FileInputStream("stream.txt") ){
		        char charStr = (char) ins.read();
		        System.out.print(charStr);
		    }
	}
	public static void tryWithResources2() throws IOException {
		try ( InputStream is  = new FileInputStream("stream.txt");
			      OutputStream os = new FileOutputStream("stream.txt")
			) {
			    char charStr = (char) is.read();
			    os.write(charStr);
			}
	}
}
