package com.lsl.dom;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class DomPaseXML {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(DomPaseXML.class.getClassLoader().getResourceAsStream("books.xml"));
		NodeList books = document.getElementsByTagName("book");
		for(int i=0;i<books.getLength();i++){
			Element book = (Element) books.item(i);
			System.out.println("编号:"+book.getElementsByTagName("bookId").item(0).getFirstChild().getNodeValue()+":"+
						"书名:"+book.getElementsByTagName("bookName").item(0).getFirstChild().getNodeValue()+
						"价格:"+book.getElementsByTagName("price").item(0).getFirstChild().getNodeValue());
			
		}
	}
}
