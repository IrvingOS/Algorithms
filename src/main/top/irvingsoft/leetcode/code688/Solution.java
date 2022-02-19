package top.irvingsoft.leetcode.code688;

/**
 * 骑士在棋盘上的概率
 *
 * @author TimeChaser
 * @since 2022/2/19 10:23
 */
public class Solution {

    private final static int[][] directions = {{-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}, {1, 2}, {2, 1}, {1, -2}, {2, -1}};

    public double knightProbabilityDFS(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return dfs(n, k, row, column, memo);
    }

    public double knightProbabilityDynamic(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (int l = 0; l <= k; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (l == 0) {
                        dp[i][j][l] = 1;
                    } else {
                        for (int[] direction : directions) {
                            int nextI = i + direction[0];
                            int nextJ = j + direction[1];
                            if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n) {
                                dp[i][j][l] += dp[nextI][nextJ][l - 1] / 8.0;
                            }
                        }
                    }
                }
            }
        }
        return dp[row][column][k];
    }

    private double dfs(int n, int k, int i, int j, double[][][] memo) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        double result = 0;
        for (int[] direction : directions) {
            result += dfs(n, k - 1, i + direction[0], j + direction[1], memo) / 8.0;
        }
        memo[i][j][k] = result;
        return result;
    }
}
