package proxy.dynamicProxy_basedonJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler{
	Object target = new Object();
	TransactionManager transactionManager= new TransactionManager();
	public TransactionHandler(Object target,TransactionManager transactionManager) {
		this.target=target;
		this.transactionManager =transactionManager;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		transactionManager.begin();
		Object object = method.invoke(target, args);
		transactionManager.end();
		return object;
		
	}
}
