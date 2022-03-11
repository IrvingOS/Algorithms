package top.irvingsoft.leetcode.code983;

/**
 * 最低票价
 *
 * @author TimeChaser
 * @since 2022/3/11 11:33 PM
 */
public class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1, j = 0; i <= n; i++) {
            if (i == days[j]) {
                dp[i] = Integer.MAX_VALUE;
                dp[i] = Math.min(dp[i - 1] + costs[0], dp[i]);
                dp[i] = Math.min(dp[Math.max(i - 7, 0)] + costs[1], dp[i]);
                dp[i] = Math.min(dp[Math.max(i - 30, 0)] + costs[2], dp[i]);
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
