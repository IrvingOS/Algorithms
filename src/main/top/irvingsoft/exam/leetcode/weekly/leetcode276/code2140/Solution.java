package top.irvingsoft.exam.leetcode.weekly.leetcode276.code2140;

/**
 * 解决智力问题
 *
 * @author TimeChaser
 * @since 2022/1/17 3:36 下午
 */
public class Solution {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] question = questions[i];
            int j = i + question[1] + 1;
            dp[i] = Math.max(dp[i + 1], question[0] + (j <= n ? dp[j] : 0));
        }
        return dp[0];
    }

}
