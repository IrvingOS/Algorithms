package top.irvingsoft.leetcode.code506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 *
 * @author TimeChaser
 * @since 2021/12/2 9:05
 */
public class Solution {

    public String[] findRelativeRanks(int[] score) {
        int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(copy);
        Map<Integer, String> map = new HashMap<>(score.length);
        for (int i = copy.length - 1; i >= 0; i--) {
            if (i == copy.length - 1) {
                map.put(copy[i], "Gold Medal");
            } else if (i == copy.length - 2) {
                map.put(copy[i], "Silver Medal");
            } else if (i == copy.length - 3) {
                map.put(copy[i], "Bronze Medal");
            } else {
                map.put(copy[i], String.valueOf(copy.length - i));
            }
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = map.get(score[i]);
        }
        return result;
    }

    public String[] findRelativeRanksAnother(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i >= 3) {
                result[arr[i][1]] = Integer.toString(i + 1);
            } else {
                result[arr[i][1]] = desc[i];
            }
        }
        return result;
    }
}
