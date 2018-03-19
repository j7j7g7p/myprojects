package com.newjdk.jdk8.defandstaatic;

import java.util.function.Supplier;

public interface Defaulable {
    // Interfaces now allow default methods, the implementer may or
    // may not implement (override) them.
    default String notRequired() {
        return "Default implementation";
    }
    
    static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}

class DefaultImpl implements Defaulable{
	
}
class OverrideImpl implements Defaulable{
	@Override
	public String notRequired() {
		  return "Overridden implementation";
	}
	
}

interface DefaulableFactory {
    // Interfaces now allow static methods
    static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}
class Test {
	public static void main(String[] args) {
		Supplier<Defaulable> supplier = DefaultImpl::new;//构造方法的引用
		Defaulable defaulable = DefaulableFactory.create(supplier);
		System.out.println(defaulable.notRequired());
		
		supplier = OverrideImpl::new;
		defaulable = DefaulableFactory.create(supplier);
		System.out.println(defaulable.notRequired());
		
		//默认方法高效，例子：java.util.Collection添加了一些好的方法
		//stream(), parallelStream(), forEach(), removeIf()
		
	}
}