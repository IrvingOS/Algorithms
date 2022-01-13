package top.irvingsoft.leetcode.code747;

/**
 * 至少是其他数字两倍的最大数
 *
 * @author TimeChaser
 * @since 2022/1/13 10:16
 */
public class Solution {

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int a = -1, b = -1;
        for (int i = 0; i < nums.length; i++) {
            if (a == -1) {
                a = i;
            } else if (nums[i] > nums[a]) {
                b = a;
                a = i;
            } else if (b == -1 || nums[i] > nums[b]) {
                b = i;
            }
        }
        return nums[b] == 0 ? a : nums[a] / nums[b] >= 2 ? a : -1;
    }
}
