package top.irvingsoft.foroffer.code13;

/**
 * 机器人的运动范围
 *
 * @author TimeChaser
 * @since 2021/11/29 10:04
 */
public class Solution {

    /**
     * 递推
     * <p>
     * 如果目标下标符合要求，则它的状态可以由其左边或者上边的状态转移过来
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int result = 1;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || get(i) + get(j) > k) {
                    continue;
                }
                if (i > 0) {
                    visited[i][j] |= visited[i - 1][j];
                }
                if (j > 0) {
                    visited[i][j] |= visited[i][j - 1];
                }
                result += visited[i][j] ? 1 : 0;
            }
        }
        return result;
    }

    /**
     * 深度优先
     */
    public int movingCountDFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || get(i) + get(j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    private int get(int x) {
        int result = 0;
        while (x != 0) {
            result += x % 10;
            x /= 10;
        }
        return result;
    }

}
