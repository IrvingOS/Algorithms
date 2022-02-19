package top.irvingsoft.leetcode.code55;

/**
 * 跳跃游戏
 *
 * @author TimeChaser
 * @since 2022/2/19 14:00
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
