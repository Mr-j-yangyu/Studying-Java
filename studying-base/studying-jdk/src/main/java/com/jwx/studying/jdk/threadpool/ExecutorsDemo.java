package com.jwx.studying.jdk.threadpool;

import com.google.common.collect.Lists;
import oracle.jrockit.jfr.jdkevents.ThrowableTracer;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.*;

/**
 * PackageName:com.jwx.studying.jdk.threadpool
 * FileName: ExecutorsDemo.java
 * Description:
 * <pre>
 *      1.利用Executors线程池方法，
 *                                  减少在创建和销毁线程上所花的时间以及系统资源的开销
 *                                  如不使用线程池，有可能造成系统创建大量线程而导致消耗完系统内存以及”过度切换
 *
 *      2.ExecutorService.submit 时，Runable接口会被包装成Callable，异常可以Future.get主动捕获，
 *                                 任务执行错误时，原线程不会被终止，可继续使用
 *
 *      3. ExecutorService.execute 任务出错时，线程终止，会创建新线程继续执行后面任务
 *
 *
 *      4. 四种线程池均继承自 ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,
 *                                      TimeUnit unit,BlockingQueue<Runnable> workQueue)
 *                  corePoolSize： 线程池维护线程的最少数量,核心线程数量
 *                  maximumPoolSize：线程池维护线程的最大数量
 *                  keepAliveTime： 线程池维护线程所允许的空闲时间
 *                  unit： 线程池维护线程所允许的空闲时间的单位
 *                  workQueue： 线程池所使用的缓冲队列
 *                  handler： 线程池对拒绝任务的处理策略
 *                      ThreadPoolExecutor.AbortPolicy()      抛出java.util.concurrent.RejectedExecutionException异常
 *                      ThreadPoolExecutor.CallerRunsPolicy()  动重复调用execute()方法
 *                      ThreadPoolExecutor.DiscardOldestPolicy() 抛弃旧任务
 *                      ThreadPoolExecutor.DiscardPolicy()      抛弃当前任务
 *
 *      !!!!!!当任务队列没有满之前，线程池大小不会超过核心线程数量的。
 *</pre>
 *
 * <p>
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/12
 */
public class ExecutorsDemo {

    /**
     *  创建可缓存线程池，当线程池中的线程空闲时间超过60s，便会终止该空闲线程并从缓存线程池中移除
     *
     *      new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
     *
     *      特点：
     *         1.因为没有对线程创建数量限制，大量线程同时运行，很有会造成系统瘫痪，需要控制任务数量
     *         2.对于大量短暂异步任务的程序来说，使用该线程池能够大大提高性能
     *         3.SynchronousQueue: 每一个新增任务的线程必须等待另一个线程取出任务，也可以把它看成容量为0的队列
     *
     */
    public void _newCachedThreadPool() throws Exception{

        ExecutorService cachedThreadPool =  Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            cachedThreadPool.execute(new MyRunable(i));
        }
        cachedThreadPool.shutdown(); //通知关闭，执行、已提交的线程执行完毕后，关闭线程池
        if(!cachedThreadPool.awaitTermination(10000, TimeUnit.SECONDS)){
            System.out.println("存在线程未执行完");
        }

    }

    /**
     *  创建一个固定线程池，超出的线程会在队列中等待
     *
     *       new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
     *
     *      特点：
     *          1.根据系统资源设置线程数量
     *          2.空闲线程不会终止，可重复利用线程
     *          3.LinkedBlockingQueue:基于链表的FIFO队列，是无界的
     *
     */
    public void _newFixedThreadPool() throws Exception{
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            Thread.sleep(100);
            fixedThreadPool.submit(new MyRunable(i));
        }
        fixedThreadPool.shutdown();

    }


    /**
     *  创建一个核心线程固定大小的线程池，支持定时及周期性任务执行
     *
     *        ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
     *
     *      特点：
     *          1.可以定期、延时执行任务
     *          2.DelayedWorkQueue 无界的BlockingQueue
     *      注意：
     *           scheduledThreadPool.scheduleAtFixedRate(new MyRunable(1),1,2,TimeUnit.SECONDS);
     *           在使用延迟1s后每2s执行时，3s过后提交线程执行，若执行前shutdown，任务将不执行
     *
     */
    public void _newScheduledThreadPool() throws Exception{

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 30; i++) {
            scheduledThreadPool.schedule(new MyRunable(i),2,TimeUnit.SECONDS); //延迟2s后执行
        }
        scheduledThreadPool.shutdown();
    }


    /**
     *   只会用唯一的工作线程来执行任务
     *
     *     new ThreadPoolExecutor(1, 1,  0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())
     *
     *      特点：
     *          1.线程不会终止，执行错误，新建线程代替
     *
     *
     */
    public void _newSingleThreadExecutor() throws Exception{
        ExecutorService fixedThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 15; i++) {
            Thread.sleep(100);
            fixedThreadPool.submit(new MyRunable(i));
        }
        fixedThreadPool.shutdown();
    }


    private class  MyRunable implements Runnable {

        private  int index=1;//执行次数
        private  int number;//任务编号

        public MyRunable(int number){this.number=number;}

        @Override
        public void run()  {
            if(number==6){
                index++;
                throw new RuntimeException("超过次数");
            }
            System.out.println(MessageFormat.format(
                    "第{0}次执行，{1}号任务，当前线程{2}",index,number ,Thread.currentThread().getName()));
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        try{
            //new ExecutorsDemo()._newCachedThreadPool();
            //new ExecutorsDemo()._newFixedThreadPool();
           // new ExecutorsDemo()._newScheduledThreadPool();
            new ExecutorsDemo()._newSingleThreadExecutor();

        }catch(Exception e){

        }
    }  

}
