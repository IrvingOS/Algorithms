package top.irvingsoft.leetcode.code42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 * <p>
 * 双指针 & 前缀数组 & 单调栈
 *
 * @author TimeChaser
 * @since 2022/2/21 16:03
 */
public class Solution {

    public int trapDoublePoint(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    public int trapPrefixAndSuffix(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }

    public int trapStack(int[] height) {
        int result = 0;
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
                result += curWidth * curHeight;
            }
            stack.push(i);
        }
        return result;
    }
}
