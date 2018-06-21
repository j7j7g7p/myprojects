package com.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 1.使用有界队列时,若有新的任务执行,如果线程池实际线程不小于corsize,则优先创建线程。
 * 2.若大于corsize,则将任务加入到队列中,等待第一个任务执行完成之后在执行队列里的任务。
 * 3.若队列中的任务已满,则在总线程数不大于maxsize前提下,创建一个新的线程(此时已经创建两个线程先执行了两次任务,然后执行队列里存放了的三个任务)
 * 4.若线程数大于maxsize,则执行拒绝策略,获取其他自定义方法。
 */
public class UseThreadpoolExecutor_1 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, // corSize
                2, // maxPoolSize
                60, // keepAliveTime
                TimeUnit.SECONDS, // unit,
                new ArrayBlockingQueue(3),// workQueue
                new MyRejected()
        );
        MyTask task1 = new MyTask(1, "任务1");
        MyTask task2 = new MyTask(2, "任务2");
        MyTask task3 = new MyTask(3, "任务3");
        MyTask task4 = new MyTask(4, "任务4");
        MyTask task5 = new MyTask(5, "任务5");
        MyTask task6 = new MyTask(6, "任务6");

        pool.execute(task1);//3、4,4会放到队列
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);
        pool.execute(task6);
        pool.shutdown();
    }
}
