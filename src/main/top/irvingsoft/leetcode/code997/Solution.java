package top.irvingsoft.leetcode.code997;

/**
 * 找到小镇的法官
 *
 * @author TimeChaser
 * @since 2021/12/19 10:18
 */
public class Solution {

    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] t : trust) {
            inDegrees[t[1]]++;
            outDegrees[t[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
