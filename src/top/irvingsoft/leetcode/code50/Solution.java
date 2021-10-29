package top.irvingsoft.leetcode.code50;

/**
 * Pow(x, n)
 *
 * @author TimeChaser
 * @date 2021/10/29 17:48
 */
public class Solution {

    public static double myPowViolence(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public static double myPowBinary(double x, int n) {
        return n > 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    public static double quickMul(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 快速幂 + 迭代
     * <p>
     * 在 n / 2 的过程中遇到奇数，则补上一次幂
     */
    public static double myPowIteration(double x, int n) {
        double result = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n = n / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPowIteration(3, 4));
    }
}
