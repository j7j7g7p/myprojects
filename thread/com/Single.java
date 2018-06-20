package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 创建只有一个线程的线程池
 */
public class Single {
    public static void main(String[] args){
        ExecutorService ex = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++){
            runnable rn = new runnable();
            ex.execute(rn);
        }
        ex.shutdown();
    }
}
class runnable implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}