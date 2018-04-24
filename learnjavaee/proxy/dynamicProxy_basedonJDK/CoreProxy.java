package proxy.dynamicProxy_basedonJDK;

public class CoreProxy implements ICore{
	private TransactionManager transactionManager ;
	private ICore core ;
	public CoreProxy(TransactionManager transactionManager,ICore core) {
		this.transactionManager =transactionManager;
		this.core=core;
	}
	@Override
	public void sing() {
		transactionManager.begin();
		core.sing();
		transactionManager.end();
	}
	@Override
	public void speak() {
		transactionManager.begin();
		core.speak();
		transactionManager.end();
	}
	
}
