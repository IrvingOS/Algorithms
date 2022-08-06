package top.irvingsoft.leetcode.code146;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }

}

/**
 * LRU 缓存机制
 *
 * @author TimeChaser
 * @since 2021/11/14 16:09
 */
public class Solution {

}