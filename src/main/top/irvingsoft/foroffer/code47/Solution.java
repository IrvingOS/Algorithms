package top.irvingsoft.foroffer.code47;

/**
 * 礼物的最大价值
 *
 * @author TimeChaser
 * @since 2021/12/6 15:35
 */
public class Solution {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

}
