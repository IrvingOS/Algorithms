package top.irvingsoft.leetcode.code258;

/**
 * 各位相加
 *
 * @author TimeChaser
 * @since 2022/3/3 10:49
 */
public class Solution {

    public int addDigits(int num) {
        int result = 0;
        while (num != 0 || result >= 10) {
            if (num == 0) {
                num = result;
                result = 0;
            }
            result += num % 10;
            num /= 10;
        }
        return result;
    }

}
