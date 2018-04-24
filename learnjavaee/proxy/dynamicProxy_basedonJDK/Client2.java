package proxy.dynamicProxy_basedonJDK;

import java.lang.reflect.Proxy;

public class Client2 {
	public static void main(String[] args) throws Throwable {
		TransactionManager transactionManager = new TransactionManager();
		ICore core = new Core();
		TransactionHandler transactionHandler = new TransactionHandler(core, transactionManager);
		
		//Method sing = Core.class.getDeclaredMethod("speak");
		//core = (ICore) transactionHandler.invoke(core, sing, null);
		ICore coreProxy = (ICore) Proxy.newProxyInstance(core.getClass().getClassLoader(), core.getClass().getInterfaces(), transactionHandler);
		coreProxy.sing();
		coreProxy.speak();
		
		ICore core2 =new Core2();
		transactionHandler = new TransactionHandler(core2, transactionManager);
		ICore coreProxy2 = (ICore) Proxy.newProxyInstance(core.getClass().getClassLoader(), core.getClass().getInterfaces(), transactionHandler);
		coreProxy2.sing();
		coreProxy2.speak();
		
	}
}
