package top.irvingsoft.leetcode.code59;

import java.util.Arrays;

/**
 * 螺旋矩阵 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/12 18:44
 */
public class Solution {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int k = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                result[i][j] = k++;
            }
            for (int j = i; j < n - i - 1; j++) {
                result[j][n - i - 1] = k++;
            }
            for (int j = n - i - 1; j > i; j--) {
                result[n - i - 1][j] = k++;
            }
            for (int j = n - i - 1; j > i; j--) {
                result[j][i] = k++;
            }
        }
        if (n % 2 == 1) {
            result[n / 2][n / 2] = k;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
