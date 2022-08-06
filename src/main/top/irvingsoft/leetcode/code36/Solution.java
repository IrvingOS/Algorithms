package top.irvingsoft.leetcode.code36;

/**
 * 有效的数独
 *
 * @author TimeChaser
 * @since 2022/1/7 11:12
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
            if (!checkColumn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkMatrix(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int j) {
        int[] nums = new int[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][j] > '0' && board[i][j] <= '9') {
                int num = board[i][j] - '0';
                nums[num]++;
                if (nums[num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkMatrix(char[][] board, int i, int j) {
        int[] nums = new int[10];
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                if (board[x][y] > '0' && board[x][y] <= '9') {
                    int num = board[x][y] - '0';
                    nums[num]++;
                    if (nums[num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int i) {
        int[] nums = new int[10];
        for (int j = 0; j < 9; j++) {
            if (board[i][j] > '0' && board[i][j] <= '9') {
                int num = board[i][j] - '0';
                nums[num]++;
                if (nums[num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
