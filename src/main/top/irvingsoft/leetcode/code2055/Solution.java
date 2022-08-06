package top.irvingsoft.leetcode.code2055;

/**
 * 蜡烛之间的盘子
 *
 * @author TimeChaser
 * @since 2022/3/8 10:26 AM
 */
public class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (arr[i] == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (arr[i] == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (arr[i] == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = right[queries[i][0]];
            int r = left[queries[i][1]];
            result[i] = l == -1 || r == -1 || l >= r ? 0 : preSum[r] - preSum[l];
        }
        return result;
    }

}
