package top.irvingsoft.leetcode.code1446;

/**
 * 连续字符
 *
 * @author TimeChaser
 * @since 2021/12/1 12:37
 */
public class Solution {

    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            while (left <= right && chars[right] != chars[left]) {
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

}
