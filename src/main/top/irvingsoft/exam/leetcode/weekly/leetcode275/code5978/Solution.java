package top.irvingsoft.exam.leetcode.weekly.leetcode275.code5978;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 统计追加字母可以获得的单词数
 *
 * @author TimeChaser
 * @since 2022/1/9 12:57
 */
public class Solution {

    /**
     * 位运算状态压缩
     * <p>
     * 提示：所有单词中均不存在重复字母
     */
    public int wordCountBit(String[] startWords, String[] targetWords) {
        int length = startWords.length;
        Set<Integer> bitSet = new HashSet<>();
        for (String startWord : startWords) {
            char[] chars = startWord.toCharArray();
            int bit = 0;
            for (char c : chars) {
                bit |= 1 << (c - 'a');
            }
            bitSet.add(bit);
        }
        int count = 0;
        for (String targetWord : targetWords) {
            char[] chars = targetWord.toCharArray();
            int bit = 0;
            for (char c : chars) {
                bit |= 1 << (c - 'a');
            }
            for (int i = 0; i < 26; i++) {
                // 找到 targetWord 中存在的字符，将存在的字符去掉后，是否存在于 bitSet 中
                if ((bit & (1 << i)) != 0) {
                    int key = bit & ~(1 << i);
                    if (bitSet.contains(key)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 字典树 + 回溯
     */
    public int wordCountTrieAndBacktrack(String[] startWords, String[] targetWords) {
        Trie root = new Trie();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String startWord : startWords) {
            int n = startWord.length();
            char[] chars = startWord.toCharArray();
            Arrays.sort(chars);
            min = Math.min(min, n);
            max = Math.max(max, n);
            Trie node = root;
            for (int i = 0; i < n; i++) {
                int index = chars[i] - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
        int count = 0;
        for (String targetWord : targetWords) {
            int n = targetWord.length();
            if (n < min + 1 || n > max + 1) {
                continue;
            }
            char[] chars = targetWord.toCharArray();
            Arrays.sort(chars);
            if (dfs(chars, 0, 0, root)) {
                count++;
            }
        }
        return count;
    }

    private boolean dfs(char[] chars, int index, int miss, Trie node) {
        if (index == chars.length) {
            return miss == 1 && node.isWord;
        }
        if (miss > 1) {
            return false;
        }
        int cur = chars[index] - 'a';
        if (node.children[cur] != null) {
            if (dfs(chars, index + 1, miss, node.children[cur])) {
                return true;
            }
        }
        index++;
        if (index == chars.length) {
            return miss == 0 && node.isWord;
        }
        cur = chars[index] - 'a';
        if (node.children[cur] != null) {
            return dfs(chars, index + 1, miss + 1, node.children[cur]);
        }
        return false;
    }

    static class Trie {
        Trie[]  children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }
}
