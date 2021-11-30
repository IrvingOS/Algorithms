package top.irvingsoft.leetcode.code400;

/**
 * 第 N 位数字
 *
 * @author TimeChaser
 * @since 2021/11/30 12:37
 */
public class Solution {

    public int findNthDigit(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        long s = (long) Math.pow(10, len - 1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        // x 为目标数字，n 为目标数字的第 n[1, len - 1] 位，为 0 时表示最后一位
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / (int) (Math.pow(10, len - n)) % 10);
    }
}
