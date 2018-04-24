package proxy.CGlibProxy;

public class Client {
	public static void main(String[] args) {
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
