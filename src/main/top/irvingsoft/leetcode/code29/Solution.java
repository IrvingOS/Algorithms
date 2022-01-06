package top.irvingsoft.leetcode.code29;

/**
 * 两数相除
 *
 * @author TimeChaser
 * @since 2022/1/6 17:29
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        int lo = 1, hi = Integer.MAX_VALUE, result = 0;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                result = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return rev ? -result : result;
    }

    public int divideBest(int dividend, int divisor) {
        boolean rev = ((dividend ^ divisor) >> 31 & 1) == 1;
        long result = 0;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        while (dividendLong >= divisorLong) {
            long i = 1;
            long temp = divisorLong;
            while (dividendLong >= temp) {
                dividendLong -= temp;
                result += i;
                i <<= 1;
                temp <<= 1;
            }
        }
        if (rev) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    public int divideViolence(int dividend, int divisor) {
        boolean rev = ((dividend ^ divisor) >> 31 & 1) == 1;
        long result = 0;
        long dividendLong = Math.abs(dividend);
        long divisorLong = Math.abs(divisor);
        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            result++;
        }
        if (rev) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    private boolean quickAdd(int y, int z, int x) {
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            z >>= 1;
        }
        return true;
    }
}
