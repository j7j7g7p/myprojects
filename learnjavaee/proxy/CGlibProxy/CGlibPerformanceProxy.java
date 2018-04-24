package proxy.CGlibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CGlibPerformanceProxy implements MethodInterceptor{
	private Enhancer enhancer=new Enhancer();
	private PerformanceMonitor performanceMonitor;
	public CGlibPerformanceProxy(PerformanceMonitor performanceMonitor) {
		this.performanceMonitor=performanceMonitor;
	}
	public Object getProxy(Class<?> clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	//拦截父类的所有方法调用
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		//通过代理类调用父类方法
		performanceMonitor.begin();
		Object result = proxy.invokeSuper(object, args);
		performanceMonitor.end();
		return result;
	}
}
