package com.dream.dp.prototype.register;
/**
 * 深浅复制
 * @author 罗尚林
 *
 */
public class Client {
	private Prototype prototype;
	private PrototypeManager ptManager;
	public void operation(Prototype example){
		prototype = example.clone();
	}
	public void registerPrototype(){
		prototype = new ConcretePrototype();
		Prototype copy = prototype.clone();
		ptManager.add(copy);
	}
}
