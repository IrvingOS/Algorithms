package top.irvingsoft.exam.leetcode.weekly.leetcode268.code2078;

/**
 * 两栋颜色不同且距离最远的房子
 *
 * @author TimeChaser
 * @since 2021/11/21 12:07
 */
public class Solution {

    public int maxDistance(int[] colors) {
        int result = 0;
        int left = 0;
        int right = colors.length - 1;
        while (left < right && colors[left] == colors[right]) {
            left++;
        }
        result = Math.max(result, right - left);
        left = 0;
        right = colors.length - 1;
        while (left < right && colors[left] == colors[right]) {
            right--;
        }
        result = Math.max(result, right - left);
        return result;
    }
}
