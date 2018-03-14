package com.dream.dp.factory.factorymethod.example;

import java.io.*;
import java.net.*;

public class URlTest {
	public static void main(String[] args) throws IOException {
		URL baidu = new URL("http://www.baidu.com");
		URLConnection baiduConnection = baidu.openConnection();
		BufferedReader in =new BufferedReader(
				new InputStreamReader(baiduConnection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();
	}
}
