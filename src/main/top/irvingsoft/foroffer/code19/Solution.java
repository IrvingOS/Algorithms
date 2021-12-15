package top.irvingsoft.foroffer.code19;

import java.util.Arrays;

/**
 * 正则表达式匹配
 *
 * @author TimeChaser
 * @since 2021/11/30 11:58
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // * 不会出现在 p 的第一个字符
                    // * 前的字符不出现
                    dp[i][j] = dp[i][j - 2];
                    // * 前的字符出现
                    if (match(s, p, i, j - 1)) {
                        // 在 s 中当前字符与 * 前字符串相同的情况下，如果 s 中当前字符之前的字符能匹配上，那当前字符也能匹配上
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else if (match(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
