package com.code.diy;

import java.util.LinkedHashMap;
import java.util.Map;

public class DIY_LRUCache {

    private Map<Integer, Integer> map;

    public DIY_LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(2 * capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key,value);
    }
}