package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 具有缓冲功能的线程池，系统根据需要创建线程，线程会被缓冲到线程池中
 * 如果线程池大小超过了处理任务所需要的线程线程池就会回收空闲的线程池，
 * 当处理任务增加时，线程池可以增加线程来处理任务线程池不会对线程的大
 * 小进行限制线程池的大小依赖于操作系统
 */
public class Cached {
    public static void main(String[] args){
        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            runnable rn = new runnable();
            ex.execute(rn);
        }
        ex.shutdown();
    }
}
