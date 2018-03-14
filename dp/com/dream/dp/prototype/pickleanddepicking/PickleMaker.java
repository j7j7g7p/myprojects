package com.dream.dp.prototype.pickleanddepicking;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;

public class PickleMaker extends Frame {
	/**
	 * 1,调用超类构造子】
	 * 2,增加一个事件监听对象
	 * 3,将布局管理器改为flow类型
	 * @param text
	 * @param size
	 */
	public PickleMaker(String text,int size){
		super("Pickle Maker");
		addWindowListener(new win());
		setLayout(new FlowLayout());
		/**
		 * 创建textField并把它串行化
		 */
		TextField textField = makeTextField(text,size);
		serializeTextField(textField,"mytextfield.ser");
		add(textField);
	}

	private void serializeTextField(TextField textField, String filename) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(textField);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TextField makeTextField(String text, int size) {
		return new TextField(text, size);
	}
	public static void main(String[] args) {
		Frame frame = new PickleMaker("No matter where you go &this.", 25);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}
}
class win extends WindowAdapter{
	public void WindowClosing(WindowEvent evt) {
		Frame frame = (Frame)evt.getSource();
		frame.setVisible(false);
		frame.dispose();
		System.exit(0);
		
	}
}
class ShowPickle extends Frame {
	public ShowPickle(String serComponent){
		super("Show Pickle");
		addWindowListener(new win());
		setLayout(new FlowLayout());
		TextField textField;
		try {
			textField = (TextField) Beans.instantiate(null, serComponent);
		} catch (Exception e) {
			System.out.println(e);
			textField = new TextField();
		}
		add(textField);
	}
	public static void main(String[] args) {
		Frame frame = new ShowPickle("mytextfield");
		frame.pack();
		frame.setVisible(true);
	}
}
