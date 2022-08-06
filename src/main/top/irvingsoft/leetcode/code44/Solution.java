package top.irvingsoft.leetcode.code44;

/**
 * 通配符匹配
 *
 * @author TimeChaser
 * @since 2021/11/3 11:11
 */
public class Solution {

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

    public static boolean isMatchAnother(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        // 将 pRight 定位到最后一个 * 的下一个字符
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
                // p 中出现 *，记录 * 号后开始匹配的下标，以便匹配失败后回溯
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                // sRecord + 1 < sRight 防止因回溯导致 sIndex 越界退出循环，sIndex 唯一导致越界的可能是上一个 else if
                // p 中 * 后的第一个字符与 s 中当前字符匹配失败，p 中下标回溯到 * 后第一个字符，s 中下标向后移一位
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }
        // 如果 sIndex < sRight，由于 pRight 指向的是通配符，所以退出循环则一定匹配
        // 如果 pIndex < pRight，只要其间全部是 * 则一定匹配
        return allStars(p, pIndex, pRight);
    }

    public static boolean isMatchDynamic(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
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

    public static void main(String[] args) {
        System.out.println(isMatchDynamic("aa", "a"));
        System.out.println(isMatchDynamic("aa", "*"));
        System.out.println(isMatchDynamic("cb", "?a"));
        System.out.println(isMatchAnother("adceb", "*a*b"));
        System.out.println(isMatchAnother("acdcb", "a*c?b"));
        System.out.println(isMatchAnother("", "*********"));
    }

}
