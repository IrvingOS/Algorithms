package top.irvingsoft.leetcode.code807;

/**
 * 保持城市天际线
 *
 * @author TimeChaser
 * @since 2021/12/13 14:19
 */
public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowSkylines = new int[n];
        int[] colSkylines = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSkylines[i] = Math.max(rowSkylines[i], grid[i][j]);
                colSkylines[j] = Math.max(colSkylines[j], grid[i][j]);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += Math.min(rowSkylines[i], colSkylines[j]) - grid[i][j];
            }
        }
        return count;
    }
}
