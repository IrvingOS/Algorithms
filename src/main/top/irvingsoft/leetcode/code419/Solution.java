package top.irvingsoft.leetcode.code419;

/**
 * 甲板上的战舰
 * <p>
 * 海战棋
 *
 * @author TimeChaser
 * @since 2021/12/18 21:37
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int count = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

}
