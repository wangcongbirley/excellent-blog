package com.source.hashmap;

import java.util.Map;
import java.util.Objects;

/**
 * Node节点代码实现
 * @author wangcongbirley
 * @date 2020-09-07
 */
public class Node<K, V> implements Map.Entry<K, V> {
	final int hash;// 哈希值，存放元素到hashmap中时用来与其他元素hash值比较
	final K key;// 键
	V value;// 值
	Node<K, V> next;

	Node(int hash, K key, V value, Node<K, V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o instanceof Map.Entry) {
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
				return true;
		}
		return false;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V newValue) {
		V oldValue = value;
		value = newValue;
		return oldValue;
	}
	@Override
	public String toString() {
		return key + "=" + value;
	}

	// 重写hashCode()方法
	@Override
	public int hashCode() {
		return Objects.hashCode(key) ^ Objects.hashCode(value);
	}
}
