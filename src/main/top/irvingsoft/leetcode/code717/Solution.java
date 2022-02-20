package top.irvingsoft.leetcode.code717;

/**
 * 1 比特与 2 比特字符
 *
 * @author TimeChaser
 * @since 2022/2/20 16:09
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i++;
            }
        }
        return false;
    }
}
