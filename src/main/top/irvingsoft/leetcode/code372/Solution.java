package top.irvingsoft.leetcode.code372;

/**
 * 超级次方
 *
 * @author TimeChaser
 * @since 2021/12/5 14:53
 */
public class Solution {

    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    /**
     * pow(a, b * c) == pow(pow(a, b), c)
     */
    private int dfs(int a, int[] b, int i) {
        if (i < 0) {
            return 1;
        }
        return pow(dfs(a, b, i - 1), 10) * pow(a, b[i]) % MOD;
    }

    private int pow(int a, int b) {
        int result = 1;
        a %= MOD;
        while (b != 0) {
            if ((b & 1) != 0) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }
}
