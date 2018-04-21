package com.lsl.dom4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.lsl.entity.Book;

public class DOM4JParseXML {
	public static void main(String[] args) throws Exception {
		List<Book> list = new ArrayList<>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src\\books.xml"));
		Element root = document.getRootElement();
		Iterator<?> iterator = root.elementIterator();
		while (iterator.hasNext()) {
			Element book = (Element) iterator.next();
			String id = book.elementText("bookId");
			String name= book.elementText("bookName");
			Book b = new Book();
			b.setId(Integer.parseInt(id));b.setName(name);
			list.add(b);
		}
		for(Book book:list){
			System.out.println(book);
		}
	}
}
