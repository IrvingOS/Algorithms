package top.irvingsoft.leetcode.code1076;

/**
 * 球会落在何处
 *
 * @author TimeChaser
 * @since 2022/2/26 18:24
 */
public class Solution {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int col = i;
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;
                if (col < 0 || col >= n || dir != row[col]) {
                    col = -1;
                    break;
                }
            }
            result[i] = col;
        }
        return result;
    }
}
