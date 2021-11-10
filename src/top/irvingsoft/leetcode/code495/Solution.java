package top.irvingsoft.leetcode.code495;

/**
 * 提莫攻击
 *
 * @author TimeChaser
 * @since 2021/11/10 14:32
 */
public class Solution {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            count += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        count = count + duration;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4, 5, 6, 9}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2, 5, 6, 9}, 2));
    }
}
