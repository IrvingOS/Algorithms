package top.irvingsoft.leetcode.code7;

/**
 * 整数反转
 *
 * @author TimeChaser
 * @date 2021/4/1 11:22
 * <p>
 * MAX_INT: 2^31 - 1 = 2147483647
 * MIN_INT:  - 2^31  = -2147483648
 */
public class Solution {

    public static int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            x = x / 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {

        System.out.println(reverse(1534236469));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }
}
