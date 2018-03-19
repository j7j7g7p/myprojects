package classloader;

import java.net.URL;

/**
 * http://blog.csdn.net/xyang81/article/details/7292380
 * @author A170227
 *
 */
public class ClassloaderTest {
	public static void main(String[] args) {
		//Classloader的类型
		/**
		 * 1，BootStrap ClassLoader：称为启动类加载器，是Java类加载层次中最顶层的类加载器，
		 * 负责加载JDK中的核心类库，如：rt.jar、resources.jar、charsets.jar等，
		 * 可通过如下程序获得该类加载器从哪些地方加载了相关的jar或class文件：
		 * */
		bootStrapClassLoader();
//		bootStrapClassLoader2();
		
		/**
		 * 2，Extension ClassLoader：称为扩展类加载器，负责加载Java的扩展类库，
		 * 默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。
		 * */
		 
		/**
		 * 3，App ClassLoader：称为系统类加载器，
		 * 负责加载应用程序classpath目录下的所有jar和class文件。
		 * */
		
	}
	
	
	
//	file:/E:/jdk1.8.0_92-64/jre/lib/resources.jar
//	file:/E:/jdk1.8.0_92-64/jre/lib/rt.jar
//	file:/E:/jdk1.8.0_92-64/jre/lib/sunrsasign.jar
//	file:/E:/jdk1.8.0_92-64/jre/lib/jsse.jar
//	file:/E:/jdk1.8.0_92-64/jre/lib/jce.jar
//	file:/E:/jdk1.8.0_92-64/jre/lib/charsets.jar
//	file:/E:/jdk1.8.0_92-64/jre/lib/jfr.jar
//	file:/E:/jdk1.8.0_92-64/jre/classes
	public static void bootStrapClassLoader() {
//		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();  
//		for (int i = 0; i < urls.length; i++) {  
//		    System.out.println(urls[i].toExternalForm());  
//		} 
	}
	
	
//	E:\jdk1.8.0_92-64\jre\lib\resources.jar
//	E:\jdk1.8.0_92-64\jre\lib\rt.jar
//	E:\jdk1.8.0_92-64\jre\lib\sunrsasign.jar
//	E:\jdk1.8.0_92-64\jre\lib\jsse.jar
//	E:\jdk1.8.0_92-64\jre\lib\jce.jar
//	E:\jdk1.8.0_92-64\jre\lib\charsets.jar
//	E:\jdk1.8.0_92-64\jre\lib\jfr.jar
//	E:\jdk1.8.0_92-64\jre\classes
	public static void bootStrapClassLoader2() {
		String bootStrapPath = System.getProperty("sun.boot.class.path");
		System.out.println(bootStrapPath.replace(";", "\n"));
	}
}
