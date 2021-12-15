package top.irvingsoft.foroffer.code16;

/**
 * 数值的整数次方
 * <p>
 * 快速幂
 *
 * @author TimeChaser
 * @since 2021/11/29 12:12
 */
public class Solution {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double result = 1.0;
        if (b < n) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
