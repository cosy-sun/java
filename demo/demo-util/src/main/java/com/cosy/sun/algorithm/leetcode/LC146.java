package com.cosy.sun.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LC146(int cap) {
        super(cap, 0.75f, true);
        this.capacity = cap;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}