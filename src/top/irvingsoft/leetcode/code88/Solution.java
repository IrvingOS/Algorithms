package top.irvingsoft.leetcode.code88;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 时间复杂度：O(m + n)
 *
 * @author TimeChaser
 * @since 2021/10/24 20:32
 */
public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m >= 0) {
            System.arraycopy(nums1, 0, nums1, n, m);
        }
        int i = 0;
        int index1 = n, index2 = 0;
        while (index1 < m + n && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[i++] = nums1[index1];
                index1++;
            } else {
                nums1[i++] = nums2[index2];
                index2++;
            }
        }
        while (index1 < m + n) {
            nums1[i++] = nums1[index1];
            index1++;
        }
        while (index2 < n) {
            nums1[i++] = nums2[index2];
            index2++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        merge(nums1, 1, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }
}
