package com.cosy.sun.jdk.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 抛弃一条最久时间没有使用的旧数据
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int cap) {
        super(cap, 0.75f, true);
        this.capacity = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
