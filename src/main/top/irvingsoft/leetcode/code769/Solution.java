package top.irvingsoft.leetcode.code769;

/*
 * 最多能完成排序的块
 */
public class Solution {

    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                result++;
            }
        }
        return result;
    }
}
