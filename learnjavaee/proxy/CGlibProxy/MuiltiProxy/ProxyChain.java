package proxy.CGlibProxy.MuiltiProxy;

import java.util.List;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyChain {
	private int cursor;
	private List<Proxy> proxies;
	private MethodProxy methodProxy;
	private Object object;
	private Object[] args;
	private Object result;
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public ProxyChain(List<Proxy> proxies,MethodProxy methodProxy,Object object,Object[] args){
		this.proxies=proxies;
		this.args=args;
		this.methodProxy=methodProxy;
		this.object=object;
	}

	public void doProxy() {
		if (cursor<proxies.size()) {
			proxies.get(cursor++).doProxy(this);
		}else {
			try {
				setResult(methodProxy.invoke(object, args));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	 
}
