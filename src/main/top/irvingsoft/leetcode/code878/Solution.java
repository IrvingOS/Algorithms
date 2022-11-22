package top.irvingsoft.leetcode.code878;

/*
 * 第 N 个神奇数字
 */
public class Solution {

    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    /*
     * 最小公倍数
     */
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /*
     * 最大公约数
     */
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
