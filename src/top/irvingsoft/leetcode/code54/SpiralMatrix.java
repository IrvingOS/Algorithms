package top.irvingsoft.leetcode.code54;

import java.util.Arrays;

/**
 * 输出螺旋矩阵
 *
 * @author TimeChaser
 * @since 2021/11/12 17:05
 */
public class SpiralMatrix {

    public static int[][] spiralMatrix(int n) {
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
        int[][] ints = spiralMatrix(6);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
