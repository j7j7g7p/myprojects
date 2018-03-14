package com.dream.dp.singleton.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Properties;

import com.base.util.StrUtils;

public class AppConfig {
	private static HashMap<Object, Object> map;
	//"properties file connot find!"
	private static byte[] nopropertiesfileE =new byte[]{112, 114, 111, 112, 101, 114, 116, 105, 101, 115, 32, 102, 105, 108, 101, 32, 99, 111, 110, 110, 111, 116, 32, 102, 105, 110, 100, 33};

	public AppConfig() {}

	public static void main(String[] args) {
		if (map == null) {
			map = new HashMap<>();
			try {
				InputStream inputStream = AppConfig.class
						.getResourceAsStream("/singleton.properties");
				Properties properties = new Properties();
				// properties文件使用HashTable读取的键值对是无序的
				/**
				 * 属性对象的重要方法load()
				 */
				properties.load(inputStream);
//				Writer outputstream = new BufferedWriter(new FileWriter("c:\\appconfig.properties"));
				String now = (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date());
				Writer outputstream = new BufferedWriter(new FileWriter("config/singleton"+now+".properties"));
				/**
				 * 属性对象的重要方法store()
				 */
				properties.store(outputstream, "appconfig_properties");
				String key, value;
				for (Iterator iterator = properties.entrySet().iterator(); iterator
						.hasNext();) {
					Entry entry = (Entry) iterator.next();
					key = String.valueOf(entry.getKey()).trim();
					value = String.valueOf(entry.getValue()).trim();
					map.put(key, value);
					System.out.println(key + "=" + value);
				}
				inputStream.close();outputstream.close();
			} catch (IOException e) {
				System.out.println(new String(nopropertiesfileE));
				e.printStackTrace();
			}
		}
	}

}
