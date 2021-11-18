package top.irvingsoft.leetcode.code208;

/**
 * 实线 Trie（前缀树）
 *
 * @author TimeChaser
 * @since 2021/10/26 12:07
 */
public class Solution {
}

class Trie {

    private final Trie[] children;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public Trie[] getChildren() {
        return this.children;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.getChildren()[index] == null) {
                node.getChildren()[index] = new Trie();
            }
            node = node.getChildren()[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = startsPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return startsPrefix(prefix) != null;
    }

    private Trie startsPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node == null || node.getChildren()[index] == null) {
                return null;
            }
            node = node.getChildren()[index];
        }
        return node;
    }
}
