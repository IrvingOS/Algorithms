package top.irvingsoft.exam.leetcode.weekly.leetcode267.code2073;

/**
 * 买票需要的时间
 *
 * @author TimeChaser
 * @since 2021/11/14 10:32
 */
public class Solution {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        while (tickets[k] > 1) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    count++;
                }
            }
        }
        for (int i = 0; i <= k; i++) {
            if (tickets[i] > 0) {
                tickets[i]--;
                count++;
            }
        }
        return count;
    }
}
