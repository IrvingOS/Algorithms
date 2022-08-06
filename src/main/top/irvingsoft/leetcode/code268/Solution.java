package top.irvingsoft.leetcode.code268;

/**
 * 丢失的数字
 *
 * @author TimeChaser
 * @since 2021/11/6 9:07
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumberAnother(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumberAnother(new int[]{0}));
    }

    public static int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int j : nums) {
            xor ^= j;
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    public static int missingNumberAnother(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

}
