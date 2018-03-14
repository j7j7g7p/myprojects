package com.dream.dp.decorator.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
//属于过滤类继承FilterReader
public class MGrepReader extends FilterReader {
	protected String subString;
	protected BufferedReader in;
	private int lineNumber;
	
	public MGrepReader(FileReader in,String subString) {
		super(in);
		this.in = new BufferedReader(in);
		this.subString =subString;
		this.lineNumber = 0;
	}
	
	public final String readLine() throws IOException {
		String line;
		do {
			line = in.readLine();
			lineNumber++;
		} while (line!=null&&line.indexOf(subString) ==-1);
		return line;
	}
	
	public int getLineNo() {
		return lineNumber;
	}
}
