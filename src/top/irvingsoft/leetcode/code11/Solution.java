package top.irvingsoft.leetcode.code11;

/**
 * 盛水最多的容器
 *
 * @author TimeChaser
 * @since 2021/11/9 10:26
 */
public class Solution {

    public static int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max(result, compute(height, left, right));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    private static int compute(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }
}
