package top.irvingsoft.leetcode.code13;

/**
 * 罗马数字转整数
 * <p>
 * 解题思：
 * 1. 从后向前解析字符串，如果当前字符代表的数值大于右值，则累加；否则，减去当前数值
 * <p>
 * 2. 从前向后解析字符串，如果当前字符代表的数值小于左值，则累加左值；否则，减去左值。因为最后的数值没有右值，所以最后的数值为正
 *
 * @author TimeChaser
 * @since 2021/4/1 12:05
 */
public class Solution {

    public static int romanToInt(String s) {

        int result = 0;
        int rightValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = getValue(s.charAt(i));
            if (current < rightValue) {
                result -= current;
            } else {
                result += current;
            }
            rightValue = current;
        }

        return result;
    }

    private static int getValue(char c) {

        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

}
