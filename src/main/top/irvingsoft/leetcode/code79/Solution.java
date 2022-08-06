package top.irvingsoft.leetcode.code79;

/**
 * 单词搜索
 *
 * @author TimeChaser
 * @since 2021/11/28 16:19
 */
public class Solution {

    public boolean dfs(int i, int j, int k, char[] word, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean result = dfs(i + 1, j, k + 1, word, board) || dfs(i - 1, j, k + 1, word, board) ||
                         dfs(i, j + 1, k + 1, word, board) || dfs(i, j - 1, k + 1, word, board);
        board[i][j] = word[k];
        return result;
    }

    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, wordChar, board)) {
                    return true;
                }
            }
        }
        return false;
    }

}
