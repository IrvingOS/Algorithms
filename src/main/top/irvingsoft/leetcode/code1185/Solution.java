package top.irvingsoft.leetcode.code1185;

/**
 * 一周中的第几天
 *
 * @author TimeChaser
 * @since 2022/1/4 11:22
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().dayOfTheWeek(4, 1, 2022));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            days += daysOfMonth[i];
        }
        days += day;
        if (month >= 3 && ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))) {
            days++;
        }
        return daysOfWeek[(days + 3) % 7];
    }

}
