package proxy.CGlibProxy.MuiltiProxy;

public class BProxy implements Proxy {

	@Override
	public void doProxy(ProxyChain chain) {
		System.out.println("B begin..");
		chain.doProxy();
		System.out.println("B end..");
	}

}
