package top.irvingsoft.leetcode.code375;

/**
 * 猜数字大小 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/12 14:11
 */
public class Solution {

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
        System.out.println(getMoneyAmount(1));
        System.out.println(getMoneyAmount(2));
    }

}
