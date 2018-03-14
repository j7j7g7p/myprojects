package com.dream.dp.adapter.xmlpropertiesVSadapter;

import java.io.FileReader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class MySAXXApp extends DefaultHandler {
	public MySAXXApp(){
		super();
	}
	public static void main(String[] args) throws Exception {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		//绑定驱动包
		MySAXXApp handler = new MySAXXApp();
		xmlReader.setContentHandler(handler);
		xmlReader.setErrorHandler(handler);
		FileReader fr = new FileReader("config/saxtest.xml");
		xmlReader.parse(new InputSource(fr));
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("end...");
	}
	@Override
	public void startDocument() throws SAXException {
		System.out.println("start...");
	}
	@Override
	public void characters(char[] ac, int start, int length) throws SAXException {
		System.out.println("character()");
		for(int i = start;i<start + length;i++ ){
			System.out.print(ac[i]);
		}
		System.out.println();
	}
	
	
}
