package top.irvingsoft.exam.leetcode.weekly.leetcode271.code5954;

/**
 * 给植物浇水
 *
 * @author TimeChaser
 * @since 2021/12/12 12:21
 */
public class Solution {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int count = 0;
        int curA = capacityA;
        int curB = capacityB;
        boolean[] status = new boolean[n];
        for (int i = 0, j = n - 1; i <= j; ) {
            if (!status[i] && curA >= plants[i]) {
                curA -= plants[i];
                status[i] = true;
            }
            if (!status[j] && curB >= plants[j]) {
                curB -= plants[j];
                status[j] = true;
            }
            if (!status[i] && !status[j]) {
                curA = capacityA;
                if (i == j) {
                    count++;
                } else {
                    curB = capacityB;
                    count += 2;
                }
            } else if (!status[i]) {
                curA = capacityA;
                count++;
            } else if (!status[j]) {
                curB = capacityB;
                count++;
            } else {
                i++;
                j--;
            }
        }
        return count;
    }
}
