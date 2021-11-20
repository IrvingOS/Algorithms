package top.irvingsoft.leetcode.code594;

import java.util.Arrays;

/**
 * 最长和谐子序列
 *
 * @author TimeChaser
 * @since 2021/11/20 22:13
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[]{1, 2, 2, 2, 3, 4, 4}));
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        for (int i = 0, j = 1; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) {
                i++;
            }
            if (nums[j] - nums[i] == 1) {
                result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }
}
