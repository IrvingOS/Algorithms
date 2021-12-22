package top.irvingsoft.leetcode.code686;

/**
 * 重复叠加字符串匹配
 * <p>
 * Rabin-Karp TODO
 * <p>
 * Knuth-Morris-Pratt
 *
 * @author TimeChaser
 * @since 2021/12/22 11:12
 */
public class Solution {

    /**
     * Knuth-Morris-Pratt
     */
    public int repeatedStringMatch(String a, String b) {
        int an = a.length();
        int bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        return (bn + index) % an != 0 ? (bn + index) / an + 1 : (bn + index) / an;
    }

    private int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] pi = new int[m];
        // 构建 π 数组
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        // 循环匹配，当 i == j + n 时退出
        for (int i = 0, j = 0; i - j < n; i++) {
            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
