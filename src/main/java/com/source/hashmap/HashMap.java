package com.source.hashmap;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * 重写HashMap代码实现
 * 
 * @author wangcongbirley
 * @param <K,V>
 * @date 2020-09-07
 */
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
	// 序列号
	private static final long serialVersionUID = 362498820763181265L;
	// 默认的初始容量是16
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	// 最大容量
	static final int MAXIMUM_CAPACITY = 1 << 30;
	// 默认的填充因子
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	// 当桶(bucket)上的结点数大于这个值时会转成红黑树
	static final int TREEIFY_THRESHOLD = 8;
	// 当桶(bucket)上的结点数小于这个值时树转链表
	static final int UNTREEIFY_THRESHOLD = 6;
	// 桶中结构转化为红黑树对应的table的最小大小
	static final int MIN_TREEIFY_CAPACITY = 64;
	// 存储元素的数组，总是2的幂次倍
	transient Node<K, V> table;
	// 存放具体元素的集
	transient Set<Entry<K, V>> entrySet;
	// 存放元素的个数，注意这个不等于数组的长度。
	transient int size;
	// 每次扩容和更改map结构的计数器
	transient int modCount;
	// 临界值 当实际大小(容量*填充因子)超过临界值时，会进行扩容
	int threshold;
	// 加载因子
	final float loadFactor;

	// 默认构造函数。
	public HashMap() {
		this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
	}

	// 包含另一个“Map”的构造函数
	public HashMap(Map<? extends K, ? extends V> m) {
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		putMapEntries(m, false);// 下面会分析到这个方法
	}

	// 指定“容量大小”的构造函数
	public HashMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	// 指定“容量大小”和“加载因子”的构造函数
	public HashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		if (loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
		this.loadFactor = loadFactor;
		// this.threshold = tableSizeFor(initialCapacity);
	}

	final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
		int s = m.size();
		if (s > 0) {
			// 判断table是否已经初始化
			if (table == null) { // pre-size
				// 未初始化，s为m的实际元素个数
				float ft = ((float) s / loadFactor) + 1.0F;
				int t = ((ft < (float) MAXIMUM_CAPACITY) ? (int) ft : MAXIMUM_CAPACITY);
				// 计算得到的t大于阈值，则初始化阈值
				if (t > threshold) {
					// threshold = tableSizeFor(t);
				}
				// 已初始化，并且m元素个数大于阈值，进行扩容处理
				else if (s > threshold) {
					// resize();
					// 将m中的所有元素添加至HashMap中
					for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
						K key = e.getKey();
						V value = e.getValue();
						// putVal(hash(key), key, value, false, evict);
					}
				}
			}
		}
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		return null;
		// return putVal(hash(key), key, value, false, true);
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
