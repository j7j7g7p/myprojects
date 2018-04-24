package proxy.staticProxy;

public class Client {
	public static void main(String[] args) {
		TransactionManager transactionManager = new TransactionManager();
		ICore core = new CoreProxy(transactionManager,new Core());
		core.sing();
		core.speak();
	}
}
