package top.irvingsoft.foroffer.code51;

import java.util.Arrays;

/**
 * 数组中的逆序对
 *
 * @author TimeChaser
 * @since 2021/12/7 9:21
 */
public class Solution {

    private int count;

    /**
     * 二分查找 + 插入排序
     */
    public int reversePairsBinaryAndInsert(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            count += rankAndInsert(nums, i - 1, nums[i]);
        }
        return count;
    }

    /**
     * 归并排序
     */
    public int reversePairsMerge(int[] nums) {
        mergeSort(nums);
        return count;
    }

    /**
     * 压缩空间的归并排序
     */
    public int reversePairsMergeBetter(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] temp = new int[nums.length];
        return reversePairs(copy, 0, copy.length - 1, temp);
    }

    private int[] merge(int[] leftNums, int[] rightNums) {
        int leftLength = leftNums.length;
        int rightLength = rightNums.length;
        int[] arr = new int[leftLength + rightLength];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (leftNums[leftIndex] <= rightNums[rightIndex]) {
                arr[index++] = leftNums[leftIndex++];
            } else {
                arr[index++] = rightNums[rightIndex++];
                count += leftLength - leftIndex;
            }
        }
        while (leftIndex < leftLength) {
            arr[index++] = leftNums[leftIndex++];
        }
        while (rightIndex < rightLength) {
            arr[index++] = rightNums[rightIndex++];
        }
        return arr;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int count = 0;
        int k = left;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        while (j <= right) {
            nums[k++] = temp[j++];
        }
        return count;
    }

    private int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] leftNums = Arrays.copyOfRange(nums, 0, mid);
        int[] rightNums = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(leftNums), mergeSort(rightNums));
    }

    private int rankAndInsert(int[] nums, int right, int target) {
        int i = 0;
        int j = right;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (right + 1 - i >= 0) {
            System.arraycopy(nums, i, nums, i + 1, right + 1 - i);
        }
        nums[i] = target;
        return i;
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }
}
