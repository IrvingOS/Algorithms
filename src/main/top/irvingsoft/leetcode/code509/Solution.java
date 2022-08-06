package top.irvingsoft.leetcode.code509;

/**
 * 斐波拉契数
 *
 * @author TimeChaser
 * @since 2022/1/21 15:17
 */
public class Solution {

    public int fib(int n) {
        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }

}
