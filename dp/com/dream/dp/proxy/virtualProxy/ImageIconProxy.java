package com.dream.dp.proxy.virtualProxy;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class ImageIconProxy implements Icon {
	private ImageIcon reallIcon = null;
	private String imageName ;
	private int width ;
	private int height;
	boolean isIconCreate = false;
	public ImageIconProxy(String imgName ,int width ,int height) {
		this.imageName = imgName;this.width =width;this.height =height;
	}
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if (isIconCreate) {
			reallIcon.paintIcon(c, g, x, y);
			g.drawString("123124131", x+20, y+370);
		}
		else {
			g.drawRect(x, y, width-1, height-1);
			g.drawString("loading...", x+20, y+20);
		}
		synchronized (this) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.currentThread().sleep(2000L);
						reallIcon = new ImageIcon(imageName);
						isIconCreate = true;
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					c.repaint();
				}
			});
		}
			
	}

	@Override
	public int getIconWidth() {
		return reallIcon.getIconWidth();
	}

	@Override
	public int getIconHeight() {
		return reallIcon.getIconHeight();
	}

}
