package top.irvingsoft.leetcode.code453;

import java.util.Arrays;

/**
 * 最小操作次数使数组元素相等
 *
 * @author TimeChaser
 * @since 2021/10/26 11:18
 */
public class Solution {

    /**
     * 使 n - 1 个元素增加 1，也就是使 1 个元素减少 1
     * <p>
     * 于是，此题的求解可以装换成：长度为 n 的数组，每次选一个数减少 1，最少需要多少次使得每个元素都相等
     *
     * @author TimeChaser
     * @since 2021/10/26 11:23
     */
    public static int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }
}
