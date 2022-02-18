package top.irvingsoft.leetcode.code1791;

/**
 * 找出星型图的中心节点
 *
 * @author TimeChaser
 * @since 2022/2/18 11:40
 */
public class Solution {

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int findCenterBest(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
