package proxy.CGlibProxy.MuiltiProxy;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyManager {
	private Class<?> targetClass;
	private List<Proxy> proxies;
	
	public ProxyManager(Class<?> targetClass,List<Proxy> proxies){
		this.proxies=proxies;
		this.targetClass=targetClass;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T createProxy(){
		return (T)Enhancer.create(targetClass, new MethodInterceptor() {
			
			@Override
			public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				ProxyChain chain=new ProxyChain(proxies, methodProxy, object, args);
				//不断调用自身
				chain.doProxy();
				return chain.getResult();
			}
		});
	}
	
}
