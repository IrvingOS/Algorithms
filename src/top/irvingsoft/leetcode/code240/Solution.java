package top.irvingsoft.leetcode.code240;

/**
 * 搜索二维矩阵 2
 *
 * @author TimeChaser
 * @date 2021/10/25 9:28
 */
public class Solution {

    public static boolean searchMatrixViolence(int[][] matrix, int target) {
        for (int[] y : matrix) {
            for (int value : y) {
                if (value == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
