package top.irvingsoft.leetcode.code162;

/**
 * 寻找峰值
 *
 * @author TimeChaser
 * @since 2021/11/16 18:48
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
