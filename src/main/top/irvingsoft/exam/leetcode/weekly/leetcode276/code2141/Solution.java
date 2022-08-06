package top.irvingsoft.exam.leetcode.weekly.leetcode276.code2141;

/**
 * 同时运行 N 台电脑的最长时间
 *
 * @author TimeChaser
 * @since 2022/1/17 4:53 下午
 */
public class Solution {

    public long maxRunTime(int n, int[] batteries) {
        int total = 0;
        for (int battery : batteries) {
            total += battery;
        }
        int lo = 0;
        int hi = total / n;
        while (lo < hi) {
            int x = lo + (hi - lo + 1) / 2;
            int sum = 0;
            for (int battery : batteries) {
                sum += Math.min(battery, x);
            }
            if (n * x <= sum) {
                lo = x;
            } else {
                hi = x - 1;
            }
        }
        return lo;
    }

    /*
     * 贪心
     */
    public long maxRunTimeAnother(int n, int[] batteries) {
        int sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        for (int i = batteries.length - 1; ; i--) {
            if (batteries[i] <= sum / n) {
                return sum / n;
            }
            sum -= batteries[i];
            n--;
        }
    }

}
