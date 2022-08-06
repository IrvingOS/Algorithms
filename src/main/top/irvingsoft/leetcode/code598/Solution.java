package top.irvingsoft.leetcode.code598;

/**
 * 范围求和 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/7 19:20
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int maxCount(int m, int n, int[][] ops) {
        int minI = m;
        int minJ = n;
        for (int[] op : ops) {
            minI = Math.min(minI, op[0]);
            minJ = Math.min(minJ, op[1]);
        }
        return minI * minJ;
    }

}
