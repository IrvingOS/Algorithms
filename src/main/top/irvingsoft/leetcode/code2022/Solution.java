package top.irvingsoft.leetcode.code2022;

/**
 * 将一位数组变成二维数组
 *
 * @author TimeChaser
 * @since 2022/1/1 11:00 上午
 */
public class Solution {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < original.length; i++) {
            result[x][y++] = original[i];
            if (y == n) {
                x++;
                y = 0;
            }
        }
        return result;
    }
}
