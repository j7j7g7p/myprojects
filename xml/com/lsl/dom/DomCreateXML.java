package com.lsl.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class DomCreateXML {
	public static void main(String[] args) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		Element root = document.createElement("books");
		document.appendChild(root);
		Element book = document.createElement("book");
		root.appendChild(book);
		Element bookId = document.createElement("bookId");
		bookId.appendChild(document.createTextNode("1"));
		book.appendChild(bookId);
		Element bookName = document.createElement("bookName");
		bookName.appendChild(document.createTextNode("钢铁是怎样炼成的？"));
		book.appendChild(bookName);
		Element bookPrice = document.createElement("price");
		bookPrice.appendChild(document.createTextNode("100"));
		book.appendChild(bookPrice);
		root.appendChild(book);
		
		TransformerFactory tsFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tsFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult streamResult = new StreamResult(new PrintWriter(new File("src\\books.xml")));
			transformer.transform(source, streamResult);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
