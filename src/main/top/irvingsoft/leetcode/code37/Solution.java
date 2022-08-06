package top.irvingsoft.leetcode.code37;

/**
 * 解数独
 *
 * @author TimeChaser
 * @since 2022/1/7 12:11
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] matrix = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int matrixIndex = i / 3 * 3 + j / 3;
                    row[i][num] = true;
                    col[j][num] = true;
                    matrix[matrixIndex][num] = true;
                }
            }
        }
        dfs(board, row, col, matrix, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] matrix, int i, int j) {
        while (board[i][j] != '.') {
            if (++j >= 9) {
                if (++i >= 9) {
                    return true;
                }
                j = 0;
            }
        }
        int matrixIndex = i / 3 * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (!row[i][num] && !col[j][num] && !matrix[matrixIndex][num]) {
                board[i][j] = (char) ('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                matrix[matrixIndex][num] = true;
                if (dfs(board, row, col, matrix, i, j)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    row[i][num] = false;
                    col[j][num] = false;
                    matrix[matrixIndex][num] = false;
                }
            }
        }
        return false;
    }

}
