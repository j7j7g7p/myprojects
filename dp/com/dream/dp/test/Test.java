package com.dream.dp.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



public class Test {
	public static void main(String[] args) {
		String jsonString = get("json.txt");
		System.out.println(jsonString);
//		String str= "[{'firstName': 'Bill','lastName': 'Gates'},{'firstName': 'George','lastName':'Bush'}]";
		List<HashMap> array = JSON.parseArray(jsonString, HashMap.class);
		System.out.println(array.get(0).get("firstName"));
	}

	public static String get(String fileName) {
		BufferedReader input = null;
		String result = "";
		File file = new File(System.getProperty("user.dir"), fileName);
		System.out.println(file.getAbsolutePath());
		try {
			if (file.exists()) {
				input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String readLine = input.readLine().trim();
				if (readLine != null) {
					result += readLine;
					readLine = input.readLine();
				}
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
