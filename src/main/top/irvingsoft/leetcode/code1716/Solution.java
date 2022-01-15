package top.irvingsoft.leetcode.code1716;

/**
 * 计算力扣银行的钱
 *
 * @author TimeChaser
 * @since 2022/1/15 13:07
 */
public class Solution {

    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int firstWeekDays = (1 + 7) * 7 / 2;
        int lastWeekDays = (weeks + weeks + 6) * 7 / 2;
        int weekDays = (firstWeekDays + lastWeekDays) * weeks / 2;
        int dayDays = (weeks + 1 + weeks + days) * days / 2;
        return weekDays + dayDays;
    }
}
