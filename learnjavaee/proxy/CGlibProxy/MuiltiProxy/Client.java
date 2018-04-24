package proxy.CGlibProxy.MuiltiProxy;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		List<Proxy> proxies = new ArrayList<>();
		proxies.add(new AProxy());
		proxies.add(new BProxy());
		
		ProxyManager proxyManager = new ProxyManager(UserService.class, proxies);
		UserService userServiceProxy = proxyManager.createProxy();
		userServiceProxy.add();
	}
}
