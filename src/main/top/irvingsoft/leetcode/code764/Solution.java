package top.irvingsoft.leetcode.code764;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 最大加号标志
 */
public class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int result = 0;
        int[][] dp = new int[n][n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        for (int[] mine : mines) {
            set.add(mine[0] * n + mine[1]);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (set.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (set.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (set.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (set.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
