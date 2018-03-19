package org.classloader.simple;

//测试是不是同一个类
public class NetClassLoaderSimple00 {
	private NetClassLoaderSimple00 instance;  
	  
    public void setNetClassLoaderSimple(Object obj) {  
    	if (obj==null) {
			throw new NullPointerException();
		}
        this.instance = (NetClassLoaderSimple00)obj;  
    }  
    
    public static void main(String[] args) {
		System.out.println("test hello!");
	}
}
