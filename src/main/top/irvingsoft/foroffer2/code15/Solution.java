package top.irvingsoft.foroffer2.code15;

/**
 * 二进制中 1 的个数
 *
 * @author TimeChaser
 * @since 2021/11/29 11:40
 */
public class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public int hammingWeightBetter(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
