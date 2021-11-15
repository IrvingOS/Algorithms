package top.irvingsoft.leetcode.code215;

import java.util.Random;

/**
 * 数组中的第 K 个最大元素
 * <p>
 * 基于快速排序的随机选择算法
 *
 * @author TimeChaser
 * @since 2021/11/15 14:43
 */
public class Solution {

    private final Random random = new Random();

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{4, 2, 1, 6, 3, 9, 7, 5, 8}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int x = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}