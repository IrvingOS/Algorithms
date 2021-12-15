package top.irvingsoft.foroffer.code12;

/**
 * 矩阵中的路径
 *
 * @author TimeChaser
 * @since 2021/11/28 16:09
 */
public class Solution {

    private final int[][] towards = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean existBest(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existMine(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] status = new boolean[board.length][board[0].length];
                    status[i][j] = true;
                    if (backtrack(i, j, 1, wordChar, board, status)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    private boolean backtrack(int m, int n, int index, char[] word, char[][] board, boolean[][] status) {
        if (index == word.length) {
            return true;
        }
        int i = 0;
        while (i < towards.length) {
            if (m + towards[i][0] >= 0 && m + towards[i][0] < board.length
                    && n + towards[i][1] >= 0 && n + towards[i][1] < board[0].length) {
                if (!status[m + towards[i][0]][n + towards[i][1]] && board[m + towards[i][0]][n + towards[i][1]] == word[index]) {
                    status[m + towards[i][0]][n + towards[i][1]] = true;
                    if (backtrack(m + towards[i][0], n + towards[i][1], index + 1, word, board, status)) {
                        return true;
                    }
                    status[m + towards[i][0]][n + towards[i][1]] = false;
                }
            }
            i++;
        }
        return false;
    }
}
