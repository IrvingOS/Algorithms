package top.irvingsoft.leetcode.code84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author TimeChaser
 * @since 2022/3/12 3:49 PM
 */
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        n += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int result = 0;
        for (int i = 1; i < n; i++) {
            while (heights[stack.peek()] > heights[i]) {
                int width = i - stack.peek() - 1;
                int height = heights[stack.pop()];
                result = Math.max(width * height, result);
            }
            stack.push(i);
        }
        return result;
    }

}
