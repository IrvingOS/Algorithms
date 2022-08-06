package top.irvingsoft.exam.leetcode.weekly.leetcode273.code5963;

/**
 * 反转两次的数字
 *
 * @author TimeChaser
 * @since 2021/12/26 13:27
 */
public class Solution {

    public boolean isSameAfterReversals(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        if (sb.length() <= 1) {
            return true;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return Integer.parseInt(sb.toString()) == num;
    }

}
