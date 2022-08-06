package top.irvingsoft.leetcode.code306;

/**
 * 累加数
 *
 * @author TimeChaser
 * @since 2022/1/11 16:01
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                if (num.charAt(secondStart) == '0' && secondEnd != secondStart) {
                    break;
                }
                if (valid(num, secondStart, secondEnd)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String thirdString(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuilder third = new StringBuilder();
        int cur = 0;
        while (firstStart <= firstEnd || secondStart <= secondEnd || cur != 0) {
            if (firstStart <= firstEnd) {
                cur += s.charAt(firstEnd--) - '0';
            }
            if (secondStart <= secondEnd) {
                cur += s.charAt(secondEnd--) - '0';
            }
            third.append(cur % 10);
            cur /= 10;
        }
        return third.reverse().toString();
    }

    private boolean valid(String num, int secondStart, int secondEnd) {
        int n = num.length();
        int firstStart = 0;
        int firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = thirdString(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

}
