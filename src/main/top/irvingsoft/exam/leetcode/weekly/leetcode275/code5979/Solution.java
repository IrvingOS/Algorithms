package top.irvingsoft.exam.leetcode.weekly.leetcode275.code5979;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 全部开花的最早一天
 *
 * @author TimeChaser
 * @since 2022/1/9 14:48
 */
public class Solution {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{plantTime[i], growTime[i]});
        }
        int cur = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            int[] times = pq.poll();
            cur += times[0];
            result = Math.max(result, cur + times[1]);
        }
        return result;
    }

}
