package top.irvingsoft.leetcode.code66;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2021/10/21 11:08
 */
public class Solution {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                // 只要存在一个元素不为 9 就会被返回
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        // digits 中所有元素都是 9
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }

    public static void main(String[] args) {

        int[] ints = {1, 2, 5, 9};
        System.out.println(Arrays.toString(plusOne(ints)));
    }
}
