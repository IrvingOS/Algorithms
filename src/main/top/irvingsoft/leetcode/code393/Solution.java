package top.irvingsoft.leetcode.code393;

/**
 * UTF-8 编码验证
 *
 * @author TimeChaser
 * @since 2022/3/13 10:16 AM
 */
public class Solution {

    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; ) {
            int t = data[i];
            int j = 7;
            while (j >= 0 && ((data[i] >> j) & 1) == 1) {
                j--;
            }
            int count = 7 - j;
            if (count == 1 || count > 4 || i + count - 1 >= n) {
                return false;
            }
            for (int k = i + 1; k < i + count; k++) {
                if (((data[k] >> 7) & 1) != 1 || ((data[k] >> 6) & 1) != 0) {
                    return false;
                }
            }
            i += count == 0 ? 1 : count;
        }
        return true;
    }

}
