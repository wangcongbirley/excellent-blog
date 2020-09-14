package com.source.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** 
 * 信号量代码实现
 * Semaphore原理：Semaphore内部有一个继承了AQS的同步器Sync，重写了tryAcquireShared方法。在这个方法里，会去尝试获取资源。
 * 如果获取失败（想要的资源数量大于目前已有的资源数量），就会返回一个负数（代表尝试获取资源失败）。然后当前线程就会进入AQS的等待队列。
 * @author wangcongbirley
 * @date 2020-09-04
 */
public class SemaphoreEx {
	// 请求的数量
	  private static final int threadCount = 550;

	  public static void main(String[] args) throws InterruptedException {
	    // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
	    ExecutorService threadPool = Executors.newFixedThreadPool(300);
	    // 一次只能允许执行的线程数量。
	    final Semaphore semaphore = new Semaphore(20,false);

	    for (int i = 0; i < threadCount; i++) {
	      final int threadnum = i;
	      threadPool.execute(() -> {// Lambda 表达式的运用
	        try {
	          semaphore.acquire(5);// 获取一个许可，所以可运行线程数量为20/1=20
	          test(threadnum);
	          semaphore.release(5);// 释放一个许可
	        } catch (InterruptedException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }

	      });
	    }
	    threadPool.shutdown();
	    System.out.println("finish");
	  }

	  public static void test(int threadnum) throws InterruptedException {
	    Thread.sleep(1000);// 模拟请求的耗时操作
	    System.out.println("threadnum:" + threadnum);
	    Thread.sleep(1000);// 模拟请求的耗时操作
	  }
}
