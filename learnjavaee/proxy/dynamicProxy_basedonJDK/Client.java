package proxy.dynamicProxy_basedonJDK;

import java.lang.reflect.Proxy;

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
}
