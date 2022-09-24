package top.irvingsoft.leetcode.code1652;

/**
 * 拆炸弹
 *
 * @author TimeChaser
 * @since 24/9/2022 下午4:51
 */
public class Solution {

    // 5 2 4 1 8 5 2 4 1 8    -2
    // 9 13 7 6 5
    // 8 1 4 2 5 8 1 4 2 5
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] doubleCode = new int[n * 2];
        for (int i = 0; i < n; i++) {
            doubleCode[i] = code[i];
            doubleCode[i + n] = code[i];
        }
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += doubleCode[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= doubleCode[l];
            sum += doubleCode[r + 1];
            l++;
            r++;
        }
        return result;
    }
}
