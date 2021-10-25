package top.irvingsoft.leetcode.code74;

/**
 * 搜索二维矩阵
 *
 * @author TimeChaser
 * @date 2021/10/25 10:31 上午
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @author TimeChaser
     * @date 2021/10/25 10:28 上午
     */
    public static boolean searchMatrixViolence(int[][] matrix, int target) {
        for (int[] y : matrix) {
            for (int value : y) {
                if (value == target) {
                    return true;
                } else if (value > target) {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrixFilter(int[][] matrix, int target) {
        for (int i = 1; i <= matrix.length; i++) {
            if (i == matrix.length || matrix[i][0] > target) {
                for (int j = 0; j < matrix[i - 1].length; j++) {
                    if (matrix[i - 1][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean searchMatrixBinary(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        if (row < 0) {
            return false;
        }
        return search(matrix[row], target);
    }

    public static int searchRow(int[][] matrix, int target) {
        int left = -1, right = matrix.length - 1;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrixBinary(ints, 3));
    }
}
