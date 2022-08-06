package top.irvingsoft.leetcode.code16;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author TimeChaser
 * @since 2021/11/9 15:11
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
        System.out.println(threeSumClosest(new int[]{1, 1, -1, -1, 3}, 3));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = 10000000;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    third--;
                    while (third > second && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else {
                    second++;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                }
            }
        }
        return result;
    }

}
