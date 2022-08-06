package top.irvingsoft.leetcode.code1154;

/**
 * 一年中的第几天
 *
 * @author TimeChaser
 * @since 2021/12/21 14:27
 */
public class Solution {

    private final int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int count = 0;
        for (int i = 0; i < month - 1; i++) {
            count += dates[i];
        }
        if (isLeapYear(year) && month > 2) {
            count++;
        }
        count += day;
        return count;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
