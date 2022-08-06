package top.irvingsoft.chengyun.oddeveninposition;

import java.util.Arrays;

/**
 * 给定一个数组，尽可能的从前往后，奇数处于奇数下标，偶数处于偶数下标
 *
 * @author TimeChaser
 * @since 2021/8/6 21:43
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(process(new int[]{1, 2, 4, 5, 6, 1, 12, 9, 7, 1, 66})));
    }

    public static int[] process(int[] nums) {

        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int indexEven = 0;
        int indexOdd = 1;

        while (indexOdd < length && indexEven < length) {

            if (nums[length - 1] % 2 == 0) {
                swap(nums, indexEven, length - 1);
                indexEven += 2;
            } else {
                swap(nums, indexOdd, length - 1);
                indexOdd += 2;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int index1, int index2) {

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
