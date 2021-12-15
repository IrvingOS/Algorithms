package top.irvingsoft.foroffer.code43;

/**
 * 1 ~ n 整数中 1 出现的次数
 *
 * @author TimeChaser
 * @since 2021/12/5 17:25
 */
public class Solution {

    public int countDigitOne(int n) {
        long bit = 1;
        int result = 0;
        while (n >= bit) {
            result += (n / (bit * 10)) * bit + Math.min(Math.max(n % (bit * 10) - bit + 1, 0), bit);
            bit *= 10;
        }
        return result;
    }
}
