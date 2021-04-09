package top.irvingsoft.leetcode.code27;

/**
 * @description: 移除元素
 *
 * 解题思路：
 *      1. 还是双指针
 *      2. 优化：当删除的元素很少时，避免做不必要的赋值操作，可以将不符合的元素与最后一个元素进行交换并释放最后一个元素。
 *
 * @author: TimeChaser
 * @date: 2021/4/9 10:14
 */
public class Solution {

    public static int removeElement(int[] nums, int val) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static int removeElementMore(int[] nums, int val) {

        int i = 0;
        int length = nums.length;
        while (i < length) {
            if (nums[i] == val) {
                nums[i] = nums[--length];
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        System.out.println(removeElementMore(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElementMore(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
