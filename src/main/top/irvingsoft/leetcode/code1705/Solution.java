package top.irvingsoft.leetcode.code1705;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 吃苹果的最大数目
 * <p>
 * 贪心 + 优先级队列
 *
 * @author TimeChaser
 * @since 2021/12/24 10:56
 */
public class Solution {

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int result = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < n) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            int rottenDay = i + days[i];
            int count = apples[i];
            if (count > 0) {
                pq.offer(new int[]{rottenDay, count});
            }
            if (!pq.isEmpty()) {
                int[] arr = pq.peek();
                arr[1]--;
                if (arr[1] == 0) {
                    pq.poll();
                }
                result++;
            }
            i++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] arr = pq.poll();
            int curr = Math.min(arr[0] - i, arr[1]);
            i += curr;
            result += curr;
        }
        return result;
    }
}
