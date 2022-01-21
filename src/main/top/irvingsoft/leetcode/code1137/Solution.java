package top.irvingsoft.leetcode.code1137;

/**
 * 第 N 个泰波拉契数
 *
 * @author TimeChaser
 * @since 2022/1/21 15:17
 */
public class Solution {

    public int tribonacci(int n) {
        int[] t = new int[n + 3];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        for (int i = 3; i <= n; i++) {
            t[i] = t[i - 3] + t[i - 2] + t[i - 1];
        }
        return t[n];
    }
}
