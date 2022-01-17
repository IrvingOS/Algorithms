package top.irvingsoft.leetcode.code1220;

/**
 * 统计元音字母序列的数目
 *
 * @author TimeChaser
 * @since 2022/1/17 11:33 上午
 */
public class Solution {

    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] ndp = new long[5];
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            ndp[1] = (dp[0] + dp[2]) % mod;
            ndp[2] = (dp[1] + dp[3]) % mod;
            ndp[3] = (dp[2]) % mod;
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
        long result = 0;
        for (int i = 0; i < 5; i++) {
            result = (result + dp[i]) % mod;
        }
        return (int) result;
    }
}
