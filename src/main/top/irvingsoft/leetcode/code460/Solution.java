package top.irvingsoft.leetcode.code460;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LFU 缓存
 *
 * @author TimeChaser
 * @since 2022/3/16 12:07 PM
 */
public class Solution {
}


class LFUCache {

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyMap;
    private Map<Integer, LinkedList<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0 || !keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).size() == 0) {
            freqMap.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        freq++;
        node.freq = freq;
        freqMap.computeIfAbsent(freq, v -> new LinkedList<>()).offerFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyMap.containsKey(key)) {
            if (keyMap.size() == capacity) {
                Node rm = freqMap.get(minFreq).pollLast();
                keyMap.remove(rm.key);
                if (freqMap.get(minFreq).size() == 0) {
                    freqMap.remove(minFreq);
                }
            }
            minFreq = 1;
            Node node = new Node(key, value, 1);
            freqMap.computeIfAbsent(minFreq, v -> new LinkedList<>()).offerFirst(node);
            keyMap.put(key, node);
        } else {
            Node node = keyMap.get(key);
            int freq  = node.freq;;
            freqMap.get(freq).remove(node);
            if (freqMap.get(freq).size() == 0) {
                freqMap.remove(freq);
                if (minFreq == freq) {
                    minFreq++;
                }
            }
            freq++;
            node.freq = freq;
            node.value = value;
            freqMap.computeIfAbsent(freq, v -> new LinkedList<>()).offerFirst(node);
            keyMap.put(key, node);
        }
    }

    class Node {
        private int key;
        private int value;
        private int freq;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
}