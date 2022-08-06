package top.irvingsoft.leetcode.code798;

/**
 * 得分最高的最小轮调
 *
 * @author TimeChaser
 * @since 2022/3/9 12:30 PM
 */
public class Solution {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = (i + 1) % n;
            int hi = (i - nums[i] + n + 1) % n;
            diff[lo]++;
            diff[hi]--;
            if (lo >= hi) {
                diff[0]++;
            }
        }
        int score = 0, maxScore = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            score += diff[i];
            if (score > maxScore) {
                maxScore = score;
                result = i;
            }
        }
        return result;
    }

}
