package proxy.dynamicProxy_basedonJDK;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * JDK 动态代理的原理：
 * 1，实现反射中的调用处理器接口 InvocationHandler，处理器中实现植入的逻辑
 * 2，通过反射传入处理器生成代理对象。
 * 3，代理对象实现被代理对象的所有接口并继承代理对象Proxy ，关联传入的处理器并使用处理器 执行具体逻辑
 */
public class Client {
	public static void main(String[] args) throws Throwable {
		TransactionManager transactionManager = new TransactionManager();
		ICore core = new Core();
		TransactionHandler transactionHandler = new TransactionHandler(core, transactionManager);
		
		//Method sing = Core.class.getDeclaredMethod("speak");
		//core = (ICore) transactionHandler.invoke(core, sing, null);
		ICore coreProxy = (ICore) Proxy.newProxyInstance(core.getClass().getClassLoader(), 
				core.getClass().getInterfaces(), transactionHandler);
		coreProxy.sing();
		
		
		PerformanceMonitor performanceMonitor = new PerformanceMonitor();
		PerformanceMonitorHandler performanceMonitorHandler = 
				new PerformanceMonitorHandler(coreProxy, performanceMonitor);
		coreProxy = (ICore) Proxy.newProxyInstance(coreProxy.getClass().getClassLoader(), 
				coreProxy.getClass().getInterfaces(), performanceMonitorHandler);
		coreProxy.sing();
	}
	
	
	@Test
    public void testGenerateProxyClass() {  
        ProxyGeneratorUtils.writeProxyClassToHardDisk("F:/$Proxy11.class");  
    }  
}
