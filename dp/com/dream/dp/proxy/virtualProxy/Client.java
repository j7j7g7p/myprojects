package com.dream.dp.proxy.virtualProxy;

import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JFrame;

public class Client extends JFrame {
	private static int width = 270;
	private static int height = 380;
	private Icon imageIconProxy =  null;
	
	public static void main(String[] args) {
		Client app = new Client();
		app.show();
	}
	public Client() {
		super("Virtual Image Proxy Client");
		imageIconProxy = new ImageIconProxy("E:\\git\\9f05b617878c89b529edf5b73f69b822\\myprojects\\web\\img\\1.jpg",width,height);
		setBounds(100,100,width+10,height+30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Insets insets = getInsets();
		imageIconProxy.paintIcon(this, g, insets.left, insets.top);
		
	}
	
}
