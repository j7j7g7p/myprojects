package com.dream.dp.dpinio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;

public class LearnIO {

	public static void main(String[] args) {
		try {			
			//适配器模式
			byte[] buf = new byte[1024];
			new ByteArrayInputStream(buf);
			InputStream inputStream = 
					new FileInputStream(new File("E:\\wp\\wp1\\myprojects\\dp\\com\\dream\\dp\\dpinio\\note.txt"));
			inputStream = new StringBufferInputStream("hello world!");
			System.out.println(inputStream.read());
			//装饰模式
			new BufferedInputStream(inputStream);
			System.out.println(inputStream.available());
			
			String str = "hello world!";
			System.out.println(str.charAt(0)&0xFF);
			System.out.println(Integer.valueOf("FF",16).toString());
			byte[] bs = {104};
			System.out.println(new String(bs));
			
			new DataInputStream(inputStream);
			new DataOutputStream(new FileOutputStream(new File("E:\\wp\\wp1\\myprojects\\dp\\com\\dream\\dp\\dpinio\\note.txt")));
			//字节流到字符流的适配  本身都是刘（字节数组）一种是字符转换成二进制形成的流，一种是原生的二进制流8位byte元流，16位char元流
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader reader2 = new BufferedReader(reader);//reader本身不提供readline方法，属于装饰模式的退化
			System.out.println(reader2.readLine());
			new OutputStreamWriter(new FileOutputStream(new File("E:\\wp\\wp1\\myprojects\\dp\\com\\dream\\dp\\dpinio\\note.txt")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
