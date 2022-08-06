package top.irvingsoft.leetcode.code53;

/**
 * 最大子序和
 *
 * @author TimeChaser
 * @since 2021/11/12 15:22
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int result = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(result, pre);
        }
        return result;
    }

}
