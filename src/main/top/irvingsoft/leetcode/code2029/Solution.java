package top.irvingsoft.leetcode.code2029;

/**
 * 石子游戏 ⅸ
 *
 * @author TimeChaser
 * @since 2022/1/20 18:06
 */
public class Solution {

    public boolean stoneGameIX(int[] stones) {
        int[] s = new int[3];
        for (int stone : stones) {
            s[stone % 3]++;
        }
        if (s[0] % 2 == 0) {
            return s[1] > 0 && s[2] > 0;
        }
        return s[1] - s[2] > 2 || s[2] - s[1] > 2;
    }

}
