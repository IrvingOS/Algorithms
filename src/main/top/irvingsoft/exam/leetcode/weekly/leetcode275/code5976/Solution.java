package top.irvingsoft.exam.leetcode.weekly.leetcode275.code5976;

import java.util.Arrays;

/**
 * 检查是否每一行每一列都包含全部整数
 *
 * @author TimeChaser
 * @since 2022/1/9 12:44
 */
public class Solution {

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                row[matrix[i][j] - 1]++;
                col[matrix[j][i] - 1]++;
            }
            if (!Arrays.equals(row, t) || !Arrays.equals(col, t)) {
                return false;
            }
        }
        return true;
    }
}
