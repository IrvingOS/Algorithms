package main.top.irvingsoft.leetcode.code472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 连接词
 *
 * @author TimeChaser
 * @since 2021/12/28 3:47 下午
 */
public class Solution {

    private final Trie root = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, 0, visited)) {
                result.add(word);
            } else {
                insert(word);
            }
        }
        return result;
    }

    private boolean dfs(String word, int start, boolean[] visited) {
        if (start == word.length()) {
            return true;
        }
        if (visited[start]) {
            return false;
        }
        Trie node = root;
        for (int i = start; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
            if (node.isEnd && dfs(word, i + 1, visited)) {
                return true;
            }
        }
        visited[start] = true;
        return false;
    }

    private void insert(String word) {
        int n = word.length();
        Trie node = root;
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    private class Trie {

        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
}
