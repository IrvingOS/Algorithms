package top.irvingsoft.foroffer.code4;

/**
 * 二维数组中的查找
 * <p>
 * N 字型搜索
 *
 * @author TimeChaser
 * @since 2021/11/24 21:20
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
