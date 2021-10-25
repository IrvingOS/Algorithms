package top.irvingsoft.leetcode.code4;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * 要求时间复杂度：O(log(m + n))
 *
 * @author TimeChaser
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
     * @date 2021/10/23 22:52
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

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

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
}
