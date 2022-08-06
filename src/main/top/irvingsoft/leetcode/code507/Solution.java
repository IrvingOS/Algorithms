package top.irvingsoft.leetcode.code507;

/**
 * 完美数
 *
 * @author TimeChaser
 * @since 2021/12/31 10:45 上午
 */
public class Solution {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        int i = 2;
        while (num / i > i) {
            if (num % i == 0) {
                sum += i + num / i;
            }
            i++;
        }
        return sum == num;
    }

}
