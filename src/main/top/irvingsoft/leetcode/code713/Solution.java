package top.irvingsoft.leetcode.code713;

/**
 * 乘积小于 K 的子数组
 *
 * @author TimeChaser
 * @since 2021/11/23 17:55
 */
public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = 0;
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
