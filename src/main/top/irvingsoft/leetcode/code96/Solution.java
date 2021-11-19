package top.irvingsoft.leetcode.code96;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的二叉搜索树
 *
 * @author TimeChaser
 * @since 2021/11/19 14:46
 */
public class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public int numTreesDFS(int n) {
        return dfs(1, n);
    }

    private int dfs(int left, int right) {
        if (left > right) {
            return 1;
        }
        if (cache.containsKey(right - left + 1)) {
            return cache.get(right - left + 1);
        }
        int count = 0;
        for (int i = left; i < right; i++) {
            int leftCount = dfs(left, i - 1);
            int rightCount = dfs(i + 1, right);
            count += leftCount * rightCount;
        }
        cache.put(right - left + 1, count);
        return count;
    }

    public int numTreesDynamic(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
