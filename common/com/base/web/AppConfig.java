package com.base.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Properties;

import com.base.util.StrUtils;

public class AppConfig {
	private static HashMap<Object, Object> map;
	
	private static byte[] nopropertiesfileE =new byte[]{112, 114, 111, 112, 101, 114, 116, 105, 101, 115, 32, 102, 105, 108, 101, 32, 99, 111, 110, 110, 111, 116, 32, 102, 105, 110, 100, 33};

	public AppConfig() {}

	public static void main(String[] args) {
		System.out.println(Arrays.toString("properties file connot find!".getBytes()));
		if (map == null) {
			map = new HashMap<>();
			try {
				InputStream inputStream = AppConfig.class
						.getResourceAsStream("/singleton.properties");
				Properties properties = new Properties();
				// properties文件使用HashTable读取的键值对是无序的
				properties.load(inputStream);
				
				String key, value, test;
				for (Iterator iterator = properties.entrySet().iterator(); iterator
						.hasNext(); test = "1") {
					Entry entry = (Entry) iterator.next();
					key = String.valueOf(entry.getKey()).trim();
					value = String.valueOf(entry.getValue()).trim();
					map.put(key, value);
//					System.out.println(key + "=" + value);
				}
				
			} catch (IOException e) {
				System.out.println(new String(nopropertiesfileE));
				e.printStackTrace();
			}
		}
	}
	
	synchronized public static void init() {
		if (map == null) {
			map = new HashMap<>();
			try {
				// 不使用properties文件
				// BufferedReader reader =new BufferedReader(new
				// FileReader("D:\\workspace\\section2\\designpattern\\config\\singleton.properties"));
				BufferedReader reader = new BufferedReader(new FileReader(
						"config/singleton.properties"));
				String readLine;
				;
				String key;
				String value;
				while ((readLine = reader.readLine()) != null) {
					String[] split = readLine.trim().split("=");
					if (split.length == 2) {
						key = split[0].trim();
						value = split[1].trim();
						if (value != null) {
							map.put(key, value);
						}
//						System.out.println(key + "=" + value);
					}
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("properties file connot find!");
				e.printStackTrace();
			}
		}
	}

	public static boolean hasPro(String s){
		init();
		if(s == null)
			return false;
		return map.containsKey(s);
	}
	
	public static boolean getBooleanPro(String s){
		String pro = getStringPro(s);
		return StrUtils.TRUE_STR.equals(pro);
	}
	
	public static String getStringPro(String s){
		if (hasPro(s)) 
			return (String) map.get(s);
		return null;
	}

	public static String getStringPro(String s, String s1){
		String value = getStringPro(s);
		if (getStringPro(s) != null)
			return value;
		return s1;
	}

	public static Integer getIntPro(String s){
		if (hasPro(s))
			return Integer.parseInt(s);
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
