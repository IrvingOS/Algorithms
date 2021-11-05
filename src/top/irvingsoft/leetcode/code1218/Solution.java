package top.irvingsoft.leetcode.code1218;

import java.util.HashMap;

/**
 * 最长定差子序列
 *
 * @author TimeChaser
 * @since 2021/11/5 15:01
 */
public class Solution {

    public static int longestSubsequence(int[] arr, int difference) {
        int m = arr.length;
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                dp[j][i] = arr[j] - arr[i];
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i][j] == difference) {
                    max = Math.max(max, backtrack(i, j, 0, difference, m, dp));
                }
            }
        }
        return max + 1;
    }

    private static int backtrack(int i, int j, int count, int target, int border, int[][] nums) {
        if (i == border || j == border) {
            return count;
        }
        for (int n = i; n < border; n++) {
            if (nums[n][j] == target) {
                return backtrack(n + 1, n, count + 1, target, border, nums);
            }
        }
        return count;
    }

    public static int longestSubsequenceHash(int[] arr, int difference) {
        int ans = 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(longestSubsequence(new int[]{1, 6, 7, 8, 9, 3, 10, 2, 11}, 1));
    }
}
