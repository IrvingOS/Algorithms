package top.irvingsoft.leetcode.code907;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * 子数组的最小值之和
 *
 * 计算每个数值的辐射范围
 * 如 [3, 1, 4, 2, 3, 1] 中，位于 i = 3 处 2 的辐射范围为 [2, 4]
 * 那么 2 能成为最小值的子序列组合为 (3 - 2 + 1) * (4 - 3 + 1) = 4
 * 那么在 2 为最小值的时候，子序列的最小值和为 2 * 4 = 8
 *
 */
public class Solution {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sumSubarrayMins(new int[]{3, 1, 4, 2, 3, 1});
    }
}
