package top.irvingsoft.foroffer.code48;

/**
 * 最长不含重复字符的子字符串
 *
 * @author TimeChaser
 * @since 2021/12/6 15:27
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int index = s.charAt(right);
            count[index]++;
            while (left <= right && count[index] != 1) {
                count[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}
