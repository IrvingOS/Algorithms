package top.irvingsoft.exam.leetcode.weekly.leetcode269.code5940;

/**
 * 从数组中移除最大值和最小值
 *
 * @author TimeChaser
 * @since 2021/11/28 15:40
 */
public class Solution {

    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i] < nums[min] ? i : min;
            max = nums[i] > nums[max] ? i : max;
        }
        int minDeletions = Integer.MAX_VALUE;
        minDeletions = Math.min(minDeletions, Math.max(min, max) + 1);
        minDeletions = Math.min(minDeletions, nums.length - Math.min(min, max));
        minDeletions = Math.min(minDeletions, min + 1 + nums.length - max);
        minDeletions = Math.min(minDeletions, max + 1 + nums.length - min);
        return minDeletions;
    }
}
