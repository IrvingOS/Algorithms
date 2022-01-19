package top.irvingsoft.leetcode.code539;

import java.util.Arrays;
import java.util.List;

/**
 * 最小时间差
 * <p>
 * 鸽巢原理
 *
 * @author TimeChaser
 * @since 2022/1/19 1:14 下午
 */
public class Solution {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = getTime(timePoints.get(i));
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
        }
        min = Math.min(min, times[0] + 1440 - times[n - 1]);
        return min;
    }

    public int getTime(String timePoint) {
        String[] time = timePoint.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
