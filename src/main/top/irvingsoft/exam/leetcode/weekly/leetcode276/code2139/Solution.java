package top.irvingsoft.exam.leetcode.weekly.leetcode276.code2139;

/**
 * 得到目标值的最小行动次数
 *
 * @author TimeChaser
 * @since 2022/1/17 3:26 下午
 */
public class Solution {

    public int minMoves(int target, int maxDoubles) {
        int result = 0;
        while (maxDoubles != 0 && target != 1) {
            result++;
            if (target % 2 == 1) {
                target--;
            } else {
                target /= 2;
                maxDoubles--;
            }
        }
        return result + target - 1;
    }

}
