package top.irvingsoft.leetcode.code2104;

/**
 * 子数组范围和
 * <p>
 * TOOD 单调栈解法
 *
 * @author TimeChaser
 * @since 2022/3/8 11:58 AM
 */
public class Solution {

    public long subArrayRanges(int[] nums) {
        long result = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += max - min;
            }
        }
        return result;
    }

}
