package com.lsl.dom4j;

import java.io.FileOutputStream;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class DOM4JCreateXML {
	public static void main(String[] args) throws Exception {
		//该方法将dom的工厂和构建器封装成帮助类
		Document document = DocumentHelper.createDocument();
		Element books = document.addElement("books");
		Element book = books.addElement("book");
		Element bookId = book.addElement("bookId");
		Element bookName =book.addElement("bookName");
		bookId.setText("101");bookName.setText("奥斯特罗斯基");
		//也是将创建过程封装
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src\\books.xml"));
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
