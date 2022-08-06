package top.irvingsoft.leetcode.code136;

/**
 * 只出现一次的数字 ⅰ
 *
 * @author TimeChaser
 * @since 2021/10/30 16:28
 */
public class Solution {

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

}
