package com.sun.structure.b_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * B tree
 * @author cosy-sun
 *
 */
public class BTree {

	private Entry root = null;
	@SuppressWarnings("unused")
	private Entry rootClone = null;
	@SuppressWarnings("unused")
	private int size = 0;
	
	public void insert(int key) {
		
		this.size ++;
	}
	
	public void delete(int key) {
		
		this.size --;
	}
	
	public void search(int key) {
		
	}
	
	public void create() {
		
	}
	
	public void setRootClone() {
		this.rootClone = this.root;
	}
	
	class Entry {
		static final int DEGREE = 2;
		Map<Integer, Object> map = new HashMap<>();
		Entry[]	subEntry = null;
		Entry parent;
		boolean leaf = false;
		public Entry(boolean leaf, Map<Integer, Object> map) {
			if(map.size() > DEGREE) {
				return ;
			}
			this.map = map;
			this.leaf = leaf;
			if(leaf) {
				subEntry = new Entry[map.size() + 1];
			}
		}
		
		public void add(int key, Object value) {
			map.put(key, value);
		}
		
		public void remove(int key) {
			map.remove(key);
		}
		
		public int keyCount() {
			return map.size();
		}
		
		public boolean isLeaf() {
			return leaf;
		}
		
		public Integer[] keySet() {
			Set<Integer> keySet = map.keySet();
			List<Integer> list = new ArrayList<>();
			keySet.forEach(x -> {
				list.add(x);
			});
			return (Integer[]) list.toArray();
		}
	}
}
