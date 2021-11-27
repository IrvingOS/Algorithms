package top.irvingsoft.leetcode.code154;

/**
 * 旋转数组的最小数字
 *
 * @author TimeChaser
 * @since 2021/11/27 15:44
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
