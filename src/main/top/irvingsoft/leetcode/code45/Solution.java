package top.irvingsoft.leetcode.code45;

/**
 * 跳跃游戏 ⅱ
 * <p>
 * 步数收集器：持续收集最大步长，但只在到达边界时跳转
 *
 * @author TimeChaser
 * @since 2022/2/20 16:25
 */
public class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

}
