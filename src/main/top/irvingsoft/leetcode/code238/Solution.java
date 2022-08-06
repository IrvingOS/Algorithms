package top.irvingsoft.leetcode.code238;

/**
 * 除自身以外数组的乘积
 *
 * @author TimeChaser
 * @since 2021/11/15 11:31
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            result[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= k;
            k *= nums[i];
        }
        return result;
    }

}
