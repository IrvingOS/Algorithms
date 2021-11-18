package top.irvingsoft.leetcode.code4;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * 要求时间复杂度：O(log(m + n))
 *
 * @author TimeChaser
 * @since 2021/3/17 19:23
 */
public class Solution {

    /**
     * 暴力解法
     * <p>
     * 合并数组，然后找中位数
     *
     * @author TimeChaser
     * @since 2021/5/3 0:57
     */
    public static double findMedianSortedArraysViolence(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        int i = 0;
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length && i <= length / 2) {
            if (nums1[index1] <= nums2[index2]) {
                nums[i++] = nums1[index1];
                index1++;
            } else {
                nums[i++] = nums2[index2];
                index2++;
            }
        }
        while (index1 < nums1.length && i <= length / 2) {
            nums[i++] = nums1[index1++];
        }
        while (index2 < nums2.length && i <= length / 2) {
            nums[i++] = nums2[index2++];
        }
        if (length % 2 != 0) {
            return nums[(length - 1) / 2];
        } else {
            return (nums[length / 2] + nums[length / 2 - 1]) / 2.0;
        }
    }

    /**
     * 直接遍历式暴力解法
     *
     * @author TimeChaser
     * @since 2021/10/27 16:34
     */
    public static double findMedianSortedArraysViolenceAnother(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int i = 0;
        int mid = length % 2 == 0 ? length / 2 - 1 : length / 2;
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] <= nums2[index2]) {
                    if (i == mid) {
                        if (length % 2 != 0) {
                            return nums1[index1];
                        } else {
                            if (index1 + 1 < nums1.length && nums1[index1 + 1] <= nums2[index2]) {
                                return (nums1[index1] + nums1[index1 + 1]) / 2.0;
                            } else {
                                return (nums1[index1] + nums2[index2]) / 2.0;
                            }
                        }
                    }
                    index1++;
                } else {
                    if (i == mid) {
                        if (length % 2 != 0) {
                            return nums2[index2];
                        } else {
                            if (index2 + 1 < nums2.length && nums2[index2 + 1] <= nums1[index1]) {
                                return (nums2[index2] + nums2[index2 + 1]) / 2.0;
                            } else {
                                return (nums1[index1] + nums2[index2]) / 2.0;
                            }
                        }
                    }
                    index2++;
                }
            } else if (index1 < nums1.length) {
                if (i == mid) {
                    if (length % 2 != 0) {
                        return nums1[index1];
                    } else {
                        return (nums1[index1] + nums1[index1 + 1]) / 2.0;
                    }
                }
                index1++;
            } else {
                if (i == mid) {
                    if (length % 2 != 0) {
                        return nums2[index2];
                    } else {
                        return (nums2[index2] + nums2[index2 + 1]) / 2.0;
                    }
                }
                index2++;
            }
            i++;
        }
        return -1;
    }

    /**
     * 二分查找
     * <p>
     * 时间复杂度：O(log(m + n))
     *
     * @author TimeChaser
     * @since 2021/10/23 22:52
     */
    public static double findMedianSortedArraysBinary(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    /**
     * 寻找两个升序数组中第 k 个元素（第 k 小的元素）
     *
     * @author TimeChaser
     * @since 2021/10/25 14:46
     */
    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    /**
     * 划分数组
     *
     * @author TimeChaser
     * @since 2021/10/27 21:58
     */
    public static double findMedianSortedArraysDivide(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysDivide(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        // 前一部分的最大值
        int median1 = 0;
        // 后一部分的最小值
        int median2 = 0;

        while (left < right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 < nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArraysDivide(nums1, nums2));
    }
}
