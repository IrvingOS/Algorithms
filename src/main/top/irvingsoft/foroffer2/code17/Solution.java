package top.irvingsoft.foroffer2.code17;

/**
 * 打印从 1 到最大的 n 位数
 *
 * @author TimeChaser
 * @since 2021/11/30 11:53
 */
public class Solution {

    public int[] printNumbers(int n) {
        int target = (int) Math.pow(10, n);
        int[] result = new int[target - 1];
        for (int i = 0; i < target - 1; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
