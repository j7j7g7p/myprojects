package proxy.CGlibProxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGlibTransactionProxy implements MethodInterceptor{
	private Enhancer enhancer=new Enhancer();
	private TransactionManager transactionManager;
	public CGlibTransactionProxy(TransactionManager transactionManager) {
		this.setTransactionManager(transactionManager);
	}
	public Object getProxy(Class<?> clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	//拦截父类的所有方法调用
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		transactionManager.begin();
		//通过代理类调用父类方法
		Object result = proxy.invokeSuper(object, args);
		transactionManager.end();
		return result;
	}
	
	
	
	
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

}
