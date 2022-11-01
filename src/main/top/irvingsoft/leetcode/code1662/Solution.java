package top.irvingsoft.leetcode.code1662;

/*
 * 检查两个字符串数组是否相等
 */
public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int m = 0;
        int n = 0;
        while(i < word1.length && j < word2.length) {
            if (word1[i].charAt(m++) != word2[j].charAt(n++)) {
                return false;
            }
            if (m == word1[i].length()) {
                i++;
                m = 0;
            }
            if (n == word2[j].length()) {
                j++;
                n = 0;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
