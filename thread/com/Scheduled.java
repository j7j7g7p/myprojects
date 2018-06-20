package com;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
 * 创建一个线程池，大小可以设置，此线程支持定时以及周期性的执行任务定时任务
 */
public class Scheduled {
    private static int pool = 2;
    public static void main(String[] args){
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(pool);
        runnable rn = new runnable();
        //参数1：目标对象   参数2：隔多长时间开始执行线程，    参数3：执行周期       参数4：时间单位
        ex.scheduleAtFixedRate(rn, 3, 1, TimeUnit.MILLISECONDS);
    }
}