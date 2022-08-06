package top.irvingsoft.exam.leetcode.weekly.leetcode273.code5965;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TimeChaser
 * @since 2021/12/26 14:22
 */
public class Solution {

    /**
     * 前缀和
     */
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] prefixValue = new long[n];
        long[] suffixValue = new long[n];
        Map<Integer, int[]> prefixMap = new HashMap<>(n);
        Map<Integer, int[]> suffixMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int[] info = prefixMap.computeIfAbsent(arr[i], v -> new int[2]);
            if (info[1] != 0) {
                prefixValue[i] = prefixValue[info[0]] + (long) (i - info[0]) * info[1];
            }
            info[0] = i;
            info[1]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            int[] info = suffixMap.computeIfAbsent(arr[i], v -> new int[2]);
            if (info[1] != 0) {
                suffixValue[i] = suffixValue[info[0]] + (long) (info[0] - i) * info[1];
            }
            info[0] = i;
            info[1]++;
        }
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefixValue[i] + suffixValue[i];
        }
        return result;
    }

}
