package top.irvingsoft.leetcode.code211;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加与搜索单词 - 数据结构设计
 *
 * @author TimeChaser
 * @date 2021/10/26 11:34
 */
public class Solution {

}

class WordDictionaryList {

    private final List<String> dict;

    public WordDictionaryList() {
        this.dict = new ArrayList<>();
    }

    public void addWord(String word) {
        this.dict.add(word);
    }

    public boolean search(String word) {
        return this.dict.contains(word) || fuzzyQuery(word);
    }

    private boolean fuzzyQuery(String word) {
        int length = word.length();
        char[] arr = word.toCharArray();
        for (String s : this.dict) {
            if (s.length() != length) {
                continue;
            }
            char[] chars = s.toCharArray();
            int i = 0;
            for (; i < length; i++) {
                if (arr[i] == '.') {
                    continue;
                }
                if (chars[i] != arr[i]) {
                    break;
                }
            }
            if (i == length) {
                return true;
            }
        }
        return false;
    }
}

class WordDictionary {

    private final Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            return child != null && dfs(word, index + 1, child);
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie {

    private final Trie[] children;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie[] getChildren() {
        return this.children;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}