package top.irvingsoft.foroffer2.code29;

/**
 * 顺时针打印矩阵
 *
 * @author TimeChaser
 * @since 2021/12/1 12:52
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] result = new int[rows * columns];
        int index = 0;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result[index++] = matrix[top][j];
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (top < bottom && left < right) {
                for (int j = right - 1; j > left; j--) {
                    result[index++] = matrix[bottom][j];
                }
                for (int i = bottom; i > top; i--) {
                    result[index++] = matrix[i][left];
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
