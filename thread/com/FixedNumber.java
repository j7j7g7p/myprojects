package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 创建具一个可重用的，有固定数量的线程池
 * 每次提交一个任务就提交一个线程，直到线程达到线城池大小，就不会创建新线程了
 * 线程池的大小达到最大后达到稳定不变，如果一个线程异常终止，则会创建新的线程
 */
public class FixedNumber {
    private static int pool = 2;
    public static void main(String[] args){
        ExecutorService ex = Executors.newFixedThreadPool(pool);
        for(int i=0; i<5; i++){
            runnable rn = new runnable();
            ex.execute(rn);
        }
        ex.shutdown();
    }
}