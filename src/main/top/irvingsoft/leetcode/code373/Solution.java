package top.irvingsoft.leetcode.code373;

import java.util.*;

/**
 * 查找和最小的 K 对数字
 *
 * @author TimeChaser
 * @since 2022/1/14 19:14
 */
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> pq = new PriorityQueue<>(k, (a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        List<List<Integer>> result = new ArrayList<>();
        while (--k >= 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            if (pair[1] + 1 < n) {
                pq.offer(new int[]{pair[0], pair[1] + 1});
            }
        }
        return result;
    }
}
