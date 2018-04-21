package com.lsl.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.lsl.entity.Book;

public class MyHandler extends DefaultHandler {
	private List<Book> list;
	private String tag;
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName);//标签名
		tag = qName;//将标签名保存下来
		if ("book".equals(tag)) {
			book = new Book();
			if (attributes!= null) {
				for(int i =0;i<attributes.getLength();i++){
					String name = attributes.getQName(i);
					String value= attributes.getValue(i);
					if ("type".equals(name)) {
						book.setType(value);
					}
					//....
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag="";//元素结束，将tag清空
		if ("book".equals(qName)) {
			list.add(book);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if ("bookId".equals(tag)) {
			book.setId(Integer.parseInt(content));
		}else if ("bookName".equals(tag)) {
			book.setName(content);
		}else if ("price".equals(tag)) {
			book.setPrice(content);
		}
	}
	
}
