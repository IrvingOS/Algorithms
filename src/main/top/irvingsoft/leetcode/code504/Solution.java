package top.irvingsoft.leetcode.code504;

/**
 * 七进制数
 *
 * @author TimeChaser
 * @since 2022/3/7 10:07 PM
 */
public class Solution {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        boolean yes = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            result.append(num % 7);
            num /= 7;
        }
        if (yes) {
            result.append("-");
        }
        return result.reverse().toString();
    }

}
