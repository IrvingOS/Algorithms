package top.irvingsoft.leetcode.code215;

import java.util.Arrays;
import java.util.Random;

/**
 * 基于原始快排的随机选择算法
 *
 * @author TimeChaser
 * @since 2021/11/15 16:54
 */
public class MySolution {

    private final Random random = new Random();

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        Solution solution = new Solution();
        MySolution mySolution = new MySolution();
        int[] partitionNums = Arrays.copyOf(nums, nums.length);
        int[] quickSortNums = Arrays.copyOf(nums, nums.length);
        long l = System.nanoTime();
        System.out.println(solution.partition(partitionNums, 0, nums.length - 1));
        long l1 = System.nanoTime();
        System.out.println(mySolution.quickSort(quickSortNums, 0, nums.length - 1));
        long l2 = System.nanoTime();
        System.out.println((l1 - l) + " : " + (l2 - l1));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(partitionNums));
        System.out.println(Arrays.toString(quickSortNums));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomQuickSort(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    private int randomQuickSort(int[] nums, int left, int right) {
        int randomPivotIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomPivotIndex);
        return quickSort(nums, left, right);
    }

    private int quickSort(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
