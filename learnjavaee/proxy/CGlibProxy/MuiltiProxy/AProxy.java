package proxy.CGlibProxy.MuiltiProxy;

public class AProxy implements Proxy {

	@Override
	public void doProxy(ProxyChain chain){
		System.out.println("A begin..");
		chain.doProxy();
		System.out.println("A end..");
	}

}
