package top.irvingsoft.leetcode.code130;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 被围绕的区域
 *
 * @author TimeChaser
 * @since 2022/1/13 11:42
 */
public class Solution {

    public void solveBFS(char[][] board) {
        int n = board.length;
        if (n == 1) {
            return;
        }
        int m = board[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                deque.offer(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                deque.offer(new int[]{i, m - 1});
            }
        }
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O') {
                deque.offer(new int[]{0, j});
            }
            if (board[n - 1][j] == 'O') {
                deque.offer(new int[]{n - 1, j});
            }
        }
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int i = poll[0];
            int j = poll[1];
            if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
                continue;
            }
            board[i][j] = 'A';
            deque.offer(new int[]{i + 1, j});
            deque.offer(new int[]{i - 1, j});
            deque.offer(new int[]{i, j + 1});
            deque.offer(new int[]{i, j - 1});
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solveDFS(char[][] board) {
        int n = board.length;
        if (n == 1) {
            return;
        }
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m - 1, n, m);
        }
        for (int j = 1; j < m - 1; j++) {
            dfs(board, 0, j, n, m);
            dfs(board, n - 1, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i + 1, j, n, m);
        dfs(board, i - 1, j, n, m);
        dfs(board, i, j + 1, n, m);
        dfs(board, i, j - 1, n, m);
    }
}
