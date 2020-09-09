package com.source.transction;
/** 
 * 事务代码实现
 * @author wangcongbirley
 * @date 2020-09-09
 */
public class transactionEx {

	/**
	 * 事务隔离级别：
	 * READ-UNCOMMITTED(读取未提交)： 最低的隔离级别，允许读取尚未提交的数据变更
	 * READ-COMMITTED(读取已提交)： 允许读取并发事务已经提交的数据
	 * REPEATABLE-READ(可重复读)： 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改
	 * SERIALIZABLE(可串行化)： 最高的隔离级别，完全服从ACID的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰
	 */
}
