package top.irvingsoft.leetcode.code209;

/**
 * 长度最小的子数组
 *
 * @author TimeChaser
 * @since 2021/11/23 18:03
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
