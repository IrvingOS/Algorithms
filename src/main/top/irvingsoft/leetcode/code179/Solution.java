package top.irvingsoft.leetcode.code179;

import java.util.Arrays;

/**
 * 最大数
 *
 * @author TimeChaser
 * @since 2022/3/13 4:08 PM
 */
public class Solution {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        // 111311 1113
        Arrays.sort(arr, (x, y) -> {
            int sx = 10, sy = 10;
            // 1000000 10000
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            // -10000 * 111311 - 113 + 1000000 * 1113 + 111311
            // -1113110000 + 1113000000 + 111311 - 1113；
            // -110000 + 111311 - 1113
            // 1311 - 1113
            return (-sy * x - y + sx * y + x);
        });
        if (arr[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }
        return sb.toString();
    }

}
