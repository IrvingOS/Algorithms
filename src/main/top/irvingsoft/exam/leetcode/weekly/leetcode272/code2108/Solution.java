package top.irvingsoft.exam.leetcode.weekly.leetcode272.code2108;

/**
 * 找出数组中的第一个回文字符串
 *
 * @author TimeChaser
 * @since 2021/12/21 15:26
 */
public class Solution {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int lo = 0;
        int hi = word.length() - 1;
        while (lo < hi) {
            if (word.charAt(lo++) != word.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }

}
