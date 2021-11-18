package top.irvingsoft.leetcode.code231;

/**
 * 二的幂
 *
 * @author TimeChaser
 * @since 2021/11/15 10:50
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if ((n >> 1) * 2 != n) {
                return false;
            }
            n >>= 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwoBetter(int n) {
        // n > 0 && (n & -n) == n;
        return n > 0 && (n & (n - 1)) == 0;
    }
}
