
package com.source.volatiles;
/** 
 * 双重锁检查单例实现
 * @author wangcongbirley
 * @date 2020-09-11
 */
public class Singleton {
	
	//使用volatile声明禁止重排序
	private static volatile Singleton instance;
	
	//双重锁检验
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized(Singleton.class) {
				if(instance==null) {
				 instance=new Singleton();
				}
			}
		}
		return instance;
		
	}
}
