package top.irvingsoft.leetcode.code786;

import java.util.*;

/**
 * 第 K 个最小的素数分数
 *
 * @author TimeChaser
 * @since 2021/11/29 8:46
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().kthSmallestPrimeFractionPriorityQueue(new int[]{1, 2, 3, 5}, 3)));
    }

    /**
     * 二分查找 + 双指针
     */
    public int[] kthSmallestPrimeFractionBinarySearch(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;
        while (true) {
            double mid = left + (right - left) / 2;
            int i = -1, count = 0;
            int x = 0, y = 1;
            for (int j = 1; j < n; j++) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }
            if (count == k) {
                return new int[]{x, y};
            }
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    /**
     * 优先级队列
     */
    public int[] kthSmallestPrimeFractionPriorityQueue(int[] arr, int k) {
        int n = arr.length;
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> arr[x[0]] * arr[y[1]] - arr[x[1]] * arr[y[0]]);
        for (int j = 1; j < n; j++) {
            queue.offer(new int[]{0, j});
        }
        for (int i = 1; i < k; i++) {
            int[] frac = queue.poll();
            int x = frac[0];
            int y = frac[1];
            if (x + 1 < y) {
                queue.offer(new int[]{x + 1, y});
            }
        }
        return new int[]{arr[queue.peek()[0]], arr[queue.peek()[1]]};
    }

    /**
     * 自定义排序
     * <p>
     * x[0] * y[1] - x[1] * y[0] 即是 x/y 的分数递增排序
     */
    public int[] kthSmallestPrimeFractionSort(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        frac.sort((x, y) -> x[0] * y[1] - x[1] * y[0]);
        return frac.get(k - 1);
    }

}
