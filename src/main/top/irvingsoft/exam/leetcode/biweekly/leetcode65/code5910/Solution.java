package top.irvingsoft.exam.leetcode.biweekly.leetcode65.code5910;

/**
 * 检查两个字符串是否几乎相等
 *
 * @author TimeChaser
 * @since 2021/11/13 22:35
 */
public class Solution {

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] counts = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            counts[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            counts[word2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (Math.abs(count) > 3) {
                return false;
            }
        }
        return true;
    }

}
