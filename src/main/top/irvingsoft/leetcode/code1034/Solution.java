package top.irvingsoft.leetcode.code1034;

/**
 * 边界着色
 *
 * @author TimeChaser
 * @since 2021/12/7 14:31
 */
public class Solution {

    private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private       int     m;
    private       int     n;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        dfs(grid, new boolean[m][n], row, col, color);
        return grid;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col, int color) {
        visited[row][col] = true;
        int count = 0;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[row][col] == grid[nextRow][nextCol] && !visited[nextRow][nextCol]) {
                dfs(grid, visited, nextRow, nextCol, color);
            }
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && visited[nextRow][nextCol]) {
                count++;
            }
        }
        if (count != 4) {
            grid[row][col] = color;
        }
    }
}
