package top.irvingsoft.exam.leetcode.weekly.leetcode268.code5201;

/**
 * 给植物浇水
 *
 * @author TimeChaser
 * @since 2021/11/21 12:10
 */
public class Solution {

    public int wateringPlants(int[] plants, int capacity) {
        int count = 0;
        int i = -1;
        int j = 0;
        int curCapacity = capacity;
        while (j < plants.length) {
            if (curCapacity >= plants[j]) {
                curCapacity -= plants[j];
                count += (j - i);
                i = j;
                j++;
            } else {
                curCapacity = capacity;
                count += Math.abs(-1 - i);
                i = -1;
            }
        }
        return count;
    }
}
