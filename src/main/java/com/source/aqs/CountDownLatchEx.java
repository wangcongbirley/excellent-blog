package com.source.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * 倒计时器代码实现
 * @author wangcongbirley
 * @date 2020-09-04
 */
public class CountDownLatchEx {
	// 请求的数量
	  private static final int threadCount = 550;

	  public static void main(String[] args) throws InterruptedException {
	    // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
	    ExecutorService threadPool = Executors.newFixedThreadPool(20);
	    final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
	    for (int i = 0; i < threadCount; i++) {
	      final int threadnum = i;
	      threadPool.execute(() -> {// Lambda 表达式的运用
	        try {
	          test(threadnum);
	        } catch (InterruptedException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        } finally {
	          countDownLatch.countDown();// 表示一个请求已经被完成
	        }

	      });
	    }
	    countDownLatch.await();
	    threadPool.shutdown();
	    System.out.println("finish");
	  }

	  public static void test(int threadnum) throws InterruptedException {
	    Thread.sleep(1000);// 模拟请求的耗时操作
	    System.out.println("threadnum:" + threadnum);
	    Thread.sleep(1000);// 模拟请求的耗时操作
	  }
}
