package top.irvingsoft.leetcode.code85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大矩形
 *
 * @author TimeChaser
 * @since 2022/3/12 4:39 PM
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            result = Math.max(largestArea(heights), result);
        }
        return result;
    }

    private int largestArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        n += 2;
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.poll()];
                int width = i - stack.peek() - 1;
                result = Math.max(height * width, result);
            }
            stack.push(i);
        }
        return result;
    }

}
