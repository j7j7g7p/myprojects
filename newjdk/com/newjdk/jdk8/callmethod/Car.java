package com.newjdk.jdk8.callmethod;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
 
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
 
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }
 
    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
    
    public static void main(String[] args) {
		//1,构造方法的引用Class::new ,泛型 Class<T>::new
    	Car car = Car.create(Car::new);
    	List<Car> cars = Arrays.asList(car);
    	//静态方法的引用  Class::static_method
    	cars.forEach(Car::collide);
    	//当前类实例的方法引用 Class::method
    	cars.forEach(Car::repair);
    	//非当前类实例的普通苹果方法引用
    	Car police = Car.create( Car::new );
    	cars.forEach(police::follow);
	}
}
