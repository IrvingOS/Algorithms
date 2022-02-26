package top.irvingsoft.leetcode.code2016;

/**
 * 增量元素之间的最大差值
 * <p>
 * 买卖股票的最佳时机
 *
 * @author TimeChaser
 * @since 2022/2/26 18:13
 */
public class Solution {

    public int maximumDifference(int[] nums) {
        int result = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return result == 0 ? -1 : result;
    }
}
