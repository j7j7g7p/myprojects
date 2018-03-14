package com.dream.dp.decorator.grep;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//属于过滤类继承FilterReader
public class CGrep {
	static MGrepReader grepReader;
	private static VGrep grepView= new VGrep();
	
	public static void main(String[] args) {
		String line;
		if (args.length<=1) {
			grepView.println("Usage :java Grep");
			grepView.println("		no regexp");
			grepView.println("		files to be searched in");
			System.exit(1);
		}
		try {
			grepView.println("\nGrep:搜索"+args[0]+" 文件"+args[1]);
			grepView.println("文件和行号\t\t 下面的行里含有所搜索的字符\n");
			grepReader = new MGrepReader( new FileReader(args[1]),args[0]);
			for(;;) {
				line =grepReader.readLine();
				if(line==null)break;
				grepView.println(args[1]+":"+grepReader.getLineNo()+":\t"+line);
			}
			grepReader.close();
		} catch (IOException e) {
			grepView.println(e.toString());
			e.printStackTrace();
		}
	}
}
