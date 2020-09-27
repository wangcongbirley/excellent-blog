package com.source.hashmap;

import java.util.LinkedHashMap;

/**
 *
 * @author wangcongbirley
 * @date 2020-09-07
 */
public class TreeNode<K, V> extends LinkedHashMap<K,V> {
	private static final long serialVersionUID = 1L;
	TreeNode<K, V> parent; // 父
	TreeNode<K, V> left; // 左
	TreeNode<K, V> right; // 右
	TreeNode<K, V> prev; // needed to unlink next upon deletion
	boolean red; // 判断颜色

	TreeNode(int hash, K key, V val, Node<K, V> next) {
		super();
	}

	// 返回根节点
	final TreeNode<K, V> root() {
		for (TreeNode<K, V> r = this, p;;) {
			if ((p = r.parent) == null)
				return r;
			r = p;
		}
	}
}
