package top.irvingsoft.leetcode.code629;

/**
 * K 个逆序对数组
 *
 * @author TimeChaser
 * @since 2021/11/11 14:53
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public static int kInversePairs(int n, int k) {
        if (k > n * (n - 1) / 2) {
            return 0;
        }
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                if (dp[i][j] < 0) {
                    dp[i][j] += MOD;
                }
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(kInversePairs(3, 3));
    }
}
