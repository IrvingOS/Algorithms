package top.irvingsoft.exam.leetcode.weekly.leetcode272.code2110;

import java.util.HashMap;
import java.util.Map;

/**
 * 股票平滑下跌阶段的数目
 *
 * @author TimeChaser
 * @since 2021/12/21 15:47
 */
public class Solution {

    private final Map<Integer, Long> cache = new HashMap<>();

    public long getDescentPeriods(int[] prices) {
        long sum = 0;
        int periods = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                periods++;
            } else {
                sum += n(periods);
                periods = 0;
            }
        }
        sum += n(periods);
        return prices.length + sum;
    }

    private long n(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        cache.put(n, result);
        return result;
    }
}
