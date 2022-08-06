package top.irvingsoft.leetcode.code1380;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵中的幸运数
 *
 * @author TimeChaser
 * @since 2022/2/15 14:57
 */
public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int minX = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][minX] > matrix[i][j]) {
                    minX = j;
                }
            }
            int maxY = 0;
            for (int k = 0; k < m; k++) {
                if (matrix[maxY][minX] < matrix[k][minX]) {
                    maxY = k;
                }
            }
            if (maxY == i) {
                result.add(matrix[i][minX]);
            }
        }
        return result;
    }

}
