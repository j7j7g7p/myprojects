package proxy.CGlibProxy;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * CGlib 代理的原理：
 * 代理类将委托类作为自己的父类并为其中的非final委托方法创建两个方法，一个是与委托方法签名相同的方法，它在方法中会通过super调用委托方法；
 * 另一个是代理类独有的方法。在代理方法中，它会判断是否存在实现了MethodInterceptor接口的对象，若存在则将调用intercept方法对委托方法进行代理
 *
 */
public class Client {
	public static void main(String[] args) {
//		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\");
		TransactionManager transactionManager = new TransactionManager();
		CGlibTransactionProxy proxy = new CGlibTransactionProxy(transactionManager);
		Core core = (Core) proxy.getProxy(Core.class);
		core.sing();
		/*//多层?????list<Interceptor>
		CGlibPerformanceProxy proxy2 = new CGlibPerformanceProxy(performanceMonitor);
		Core core2 = (Core) proxy2.getProxy(core.getClass());
		core2.sing();*/
		
	}
}
