package com.dream.dp.adapter.xmlpropertiesVSadapter;

import java.io.InputStream;
import java.util.Properties;

public class XMLProperties extends Properties{
	XMLParser p = null;
	public synchronized void load(InputStream in){
//		p =  new XMLParser(in , this);
	}
}
