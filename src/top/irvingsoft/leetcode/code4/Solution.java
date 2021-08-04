package top.irvingsoft.leetcode.code4;

/**
 * @author TimeChaser
 * 寻找两个正序数组的中位数
 * @date 2021/3/17 19:23
 */
public class Solution {

    /**
     * 暴力解法
     * <p>
     * 合并数组，然后找中位数
     *
     * @author TimeChaser
     * @date 2021/5/3 0:57
     */
    public static double findMedianSortedArraysViolence(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            nums[index++] = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
        }
        while (index1 < nums1.length) {
            nums[index++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            nums[index++] = nums2[index2++];
        }
        if (length % 2 == 0) {
            return (nums[length / 2] + nums[length / 2 - 1]) / 2.0;
        } else {
            return nums[(length - 1) / 2] * 1.0;
        }
    }

    public static void main(String[] args) {

    }
}
