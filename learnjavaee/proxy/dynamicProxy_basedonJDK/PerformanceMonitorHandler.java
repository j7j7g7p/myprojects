package proxy.dynamicProxy_basedonJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceMonitorHandler implements InvocationHandler{
	Object target;
	PerformanceMonitor performanceMonitor;
	public PerformanceMonitorHandler(Object target,PerformanceMonitor performanceMonitor) {
		this.performanceMonitor=performanceMonitor;
		this.target=target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		performanceMonitor.begin();
		Object object = method.invoke(target, args);
		performanceMonitor.end();
		return object;
	}
	
}
