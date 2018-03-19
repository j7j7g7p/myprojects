package com.newjdk.jdk7.fileio;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
	
	public static void main(String[] args) {
		try {
			test();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test() throws IOException {
		//路劲的创建，
		Path path1   = Paths.get("/home/biezhi", "a.txt");
		Path path2   = Paths.get("/home/biezhi/a.txt");
		URI  u       = URI.create("file:////home/biezhi/a.txt");
		Path pathURI = Paths.get(u);
		Path filePath = FileSystems.getDefault().getPath("/home/biezhi", "a.txt");
		//Path、URI、File之间的转换
		File file  = new File("/home/biezhi/a.txt");
		Path p1    = file.toPath();
		p1.toFile();
		file.toURI();
		
		//Files对象对文件的读取
		Path path = Paths.get("stream.txt");
		byte[] data    = Files.readAllBytes(path);
		String content = new String(data, StandardCharsets.UTF_8);
		System.out.println(content);
		//File对象的常用方法
//		try(
//				InputStream ins = Files.newInputStream(path);
//				OutputStream ops = Files.newOutputStream(path);
//				Reader reader = Files.newBufferedReader(path);
//				Writer writer = Files.newBufferedWriter(path);		
//		) {
//			
//		}
		//文件夹操作
		Path dir = Paths.get("web");
		Path createTempFile = Files.createTempFile(dir, null, ".txt");
		System.out.println(createTempFile);
		Files.createTempFile(null, null);
//		Files.createTempDirectory(dir, null);
//		Files.createTempDirectory(null);
		
		//文件的目录使用：读取一个目录下的文件请使用Files.list和Files.walk方法
		//复制、移动一个文件内容到某个路径
		Path in = Paths.get("stream.txt");
		Path d = Paths.get("web/stream.txt");
//		Files.copy(in, d);
//		Files.move(in, d);
		
		//删除文件
		Files.delete(d);
		
	}
}
