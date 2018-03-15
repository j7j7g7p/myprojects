package org.classloader.simple;

//测试是不是同一个类
public class NetClassLoaderSimple {
	private NetClassLoaderSimple instance;  
	  
    public void setNetClassLoaderSimple(Object obj) {  
    	if (obj==null) {
			throw new NullPointerException();
		}
        this.instance = (NetClassLoaderSimple)obj;  
    }  
}
