package top.irvingsoft.leetcode.code677;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    private final Map<String, Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }

}

class MapSumHash {

    private final Map<String, Integer> map;
    private final Map<String, Integer> prefixMap;

    public MapSumHash() {
        this.map = new HashMap<>();
        this.prefixMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }

}

class MapSumTrie {

    private final Map<String, Integer> map;
    private final TrieNode root;

    public MapSumTrie() {
        this.root = new TrieNode();
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }
            node = node.next[ch - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                return 0;
            }
            node = node.next[ch - 'a'];
        }
        return node.val;
    }

    public class TrieNode {

        TrieNode[] next = new TrieNode[26];
        int val = 0;

    }

}

/**
 * 键值映射
 *
 * @author TimeChaser
 * @since 2021/11/14 8:51
 */
public class Solution {

}