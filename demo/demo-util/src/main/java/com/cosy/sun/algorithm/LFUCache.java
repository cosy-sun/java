package com.cosy.sun.algorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * LFU维护了两个链表，横向组成的链表用来存储访问频率，每个访问频率的节点下存储另外一个具有相同访问频率的缓存数据。
 * 具体的工作原理是：
 * <p>
 * 当添加元素时，找到相同访问频次的节点，然后添加到该节点的数据链表的头部。如果该数据链表满了，则移除链表尾部的节点当获取元素或者修改元素是，都会增加对应key的访问频次，并把当前节点移动到下一个频次节点。
 * 添加元素时，访问频率默认为1，随着访问次数的增加，频率不断递增。而当前被访问的元素也会随着频率增加进行移动。
 */
public class LFUCache<K, V> {

    /**
     * 最大缓存的数量
     */
    private int cap;

    /**
     * 缓存
     */
    private HashMap<K, V> values;

    /**
     * 缓存的访问频次的key-count
     */
    private HashMap<K, Integer> counts;

    /**
     * 同一访问频次的缓存
     */
    private HashMap<Integer, LinkedHashSet<K>> frequency;

    /**
     * 记录要淘汰时的count
     */
    private int min = -1;

    /**
     * 缓存的大小
     */
    public int size = 0;

    public LFUCache(int cap) {
        this.cap = cap;
        values = new HashMap<>();
        counts = new HashMap<>();
        frequency = new HashMap<>();
        frequency.put(1, new LinkedHashSet<>());
    }

    /**
     * put值时:
     * 1.当缓存未满，key不存在时，存入缓存，counts中的访问次数记为1（即put也视为访问了该缓存）
     * 2.当缓存未满，key存在时，覆盖缓存，counts中的访问次数加1（即put也视为访问了该缓存）
     * 3.当缓存已满，删除距今最久且访问此数最少的key,再将新的key放入缓存
     */
    public void put(K key, V value) {
        Integer count = 1;
        //put时key已经存在则覆盖原来的值，并调用get方法将count加1
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }
        //缓存的数量超过cap时淘汰距今最久且访问次数最少的
        if (values.size() >= cap) {
            K removeKey = frequency.get(min).iterator().next();
            values.remove(removeKey);
            counts.remove(removeKey);
            frequency.get(min).remove(removeKey);
        } else {
            size++;
        }
        //缓存未满或缓存满了后淘汰一个后put值到缓存中
        values.put(key, value);
        counts.put(key, count);
        if (!frequency.containsKey(count)) {
            frequency.put(count, new LinkedHashSet<>());
        }
        frequency.get(count).add(key);
        min = 1;
    }

    /**
     * get值时:
     * 1.当缓存中没有该缓存时，返回null
     * 2.当缓存中有该缓存时，返回缓存，并且counts和 frequency中缓存访问数量加1
     */
    public V get(K key) {
        V value = null;
        if (values.containsKey(key)) {
            value = values.get(key);
            //更新counts中记录的key对应的数量
            int count = counts.get(key);
            counts.put(key, count + 1);
            //更新最少访问的key的数量min
            frequency.get(count).remove(key);

            abc(count);
            //更新frequency中记录的数量对应的key
            if (!frequency.containsKey(count + 1)) {
                frequency.put(count + 1, new LinkedHashSet<>());
            }
            frequency.get(count + 1).add(key);
        }
        return value;
    }

    private void abc(int count) {
        int frequencyCountSize = frequency.get(count).size();
        if (count == min && frequencyCountSize == 0) {
            min++;
        }
        if (frequencyCountSize == 0) {
            frequency.remove(count);
        }
    }

    /**
     * 清除所有缓存
     */
    public void clear() {
        values.clear();
        counts.clear();
        frequency.clear();
        min = -1;
        size = 0;
    }

    /**
     * 判断是否包含
     */
    public boolean contains(K key) {
        return values.containsKey(key);
    }

    /**
     * 删除某一缓存
     */
    public void remove(K key) {
        if (values.containsKey(key)) {
            values.remove(key);
            int count = counts.get(key);
            counts.remove(key);
            frequency.get(count).remove(key);
            size--;
            abc(count);
        }
    }


    public int getCap() {
        return cap;
    }

    public HashMap<K, V> getValues() {
        return values;
    }

    public HashMap<K, Integer> getCounts() {
        return counts;
    }

    public HashMap<Integer, LinkedHashSet<K>> getFrequency() {
        return frequency;
    }

    public int getMin() {
        return min;
    }


}
