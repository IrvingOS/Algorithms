package top.irvingsoft.leetcode.code537;

/**
 * 复数乘法
 * <p>
 * \\+
 *
 * @author TimeChaser
 * @since 2022/2/26 18:18
 */
public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num1.split("\\+|i");
        int a = Integer.parseInt(complex1[0]);
        int b = Integer.parseInt(complex1[1]);
        int c = Integer.parseInt(complex2[0]);
        int d = Integer.parseInt(complex2[1]);
        return (a * c - b * d) + "+" + (a * d + b * c) + "i";
    }
}
