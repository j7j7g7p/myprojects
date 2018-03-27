package classloader;

import org.junit.Test;

/**
 * jvm区分一个类不光是通过包名，也会去判断是不是同一个类加载器
 * 验证
 * @author A170227
 *
 */
public class NewworkClassLoaderTest {  
	  
    public static void main(String[] args) {  
        try {  
            //测试加载网络中的class文件  
            String rootUrl = "http://localhost:8080/httpweb/classes";  
            String className = "org.classloader.simple.NetClassLoaderSimple";  //本地不能存在NetClassLoaderSimple
            NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);  
            NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);  
            Class<?> clazz1 = ncl1.loadClass(className);  
            Class<?> clazz2 = ncl2.loadClass(className);  
            Object obj1 = clazz1.newInstance();  
            Object obj2 = clazz2.newInstance();  
            clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    @Test
    public void testClassLoader() throws ClassNotFoundException {
    	String rootUrl = "http://localhost:8080/httpweb/classes";  
        String className = "org.classloader.simple.NetClassLoaderSimple1";  //本地不能存在NetClassLoaderSimple
        NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);  
        Class<?> clazz1 = ncl1.loadClass(className); 
        ClassLoader loader = clazz1.getClassLoader();
        System.out.println(loader);
        //输出：classloader.NetworkClassLoader@f2a0b8e
    }
}  