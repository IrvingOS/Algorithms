package top.irvingsoft.leetcode.code240;

/**
 * 搜索二维矩阵 2
 *
 * @author TimeChaser
 * @since 2021/10/25 9:28
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @author TimeChaser
     * @since 2021/10/25 10:28 上午
     */
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

    /**
     * 二分法
     *
     * @author TimeChaser
     * @since 2021/10/25 10:28 上午
     */
    public static boolean searchMatrixBinary(int[][] matrix, int target) {
        for (int[] y : matrix) {
            if (search(y, target) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Z 字形搜索法
     *
     * @author TimeChaser
     * @since 2021/10/25 10:28 上午
     */
    public static boolean searchMatrixZ(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[x].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
