package top.irvingsoft.leetcode.code54;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author TimeChaser
 * @since 2021/11/12 16:19
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrderAnother(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns ||
                visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return result;
    }

    public static List<Integer> spiralOrderAnother(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        // == 条件为了读取到正中间的数
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            // 防止 == 条件下，重复的读取
            // 1. [1, 2, 3]
            // 2. [1]
            //    [2]
            //    [3]
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

}
