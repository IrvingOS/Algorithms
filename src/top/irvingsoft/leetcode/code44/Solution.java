package top.irvingsoft.leetcode.code44;

/**
 * 通配符匹配
 *
 * @author TimeChaser
 * @since 2021/11/3 11:11
 */
public class Solution {

    public static boolean isMatchDynamic(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 1]) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatchAnother(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                --sRight;
                --pRight;
            } else {
                return false;
            }
        }
        if (pRight == 0) {
            return sRight == 0;
        }
        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;
        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }
        return allStars(p, pIndex, pRight);
    }

    public static boolean allStars(String str, int left, int right) {
        for (int i = left; i < right; i++) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }

    public static void main(String[] args) {
        System.out.println(isMatchDynamic("aa", "a"));
        System.out.println(isMatchDynamic("aa", "*"));
        System.out.println(isMatchDynamic("cb", "?a"));
        System.out.println(isMatchAnother("adceb", "*a*b"));
        System.out.println(isMatchAnother("acdcb", "a*c?b"));
        System.out.println(isMatchAnother("", "*********"));
    }
}
