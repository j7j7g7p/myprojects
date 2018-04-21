package com.lsl.sax;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.lsl.entity.Book;

public class SaxPaseXML {
	public static void main(String[] args) throws Exception {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		MyHandler myhandler = new MyHandler();
		saxParser.parse(new File("books.xml"), myhandler);
		List<Book> list = myhandler.getList();
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
