package top.irvingsoft.leetcode.code344;

/**
 * 反转字符串
 *
 * @author TimeChaser
 * @since 2021/11/15 10:55
 */
public class Solution {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }
    }

}
