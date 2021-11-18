package top.irvingsoft.leetcode.code153;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author TimeChaser
 * @since 2021/11/16 18:44
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
