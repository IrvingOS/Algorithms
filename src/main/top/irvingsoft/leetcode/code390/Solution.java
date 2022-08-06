package top.irvingsoft.leetcode.code390;

/**
 * 消除游戏
 *
 * @author TimeChaser
 * @since 2022/1/1 11:49 上午
 */
public class Solution {

    public int lastRemaining(int n) {
        int count = n;
        int k = 0, step = 1;
        int a1 = 1, an = n;
        while (count > 1) {
            if (k % 2 == 0) {
                a1 += step;
                an -= count % 2 != 0 ? step : 0;
            } else {
                an -= step;
                a1 += count % 2 != 0 ? step : 0;
            }
            k++;
            step <<= 1;
            count >>= 1;
        }
        return a1;
    }

}
