package top.irvingsoft.leetcode.code87;

import java.util.HashMap;
import java.util.Map;

/**
 * 扰乱字符串
 *
 * @author TimeChaser
 * @since 2021/11/7 21:41
 */
public class Solution {

    private static int[][][] dp;
    private static String str1;
    private static String str2;

    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        str1 = s1;
        str2 = s2;
        dp = new int[n][n][n + 1];
        return dfs(0, 0, n);
    }

    public static void main(String[] args) {
        //        System.out.println(isScramble("great", "rgeat"));
        //        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("great", "trega"));
    }

    private static boolean checkIfSimilar(int i1, int i2, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = i1; i < i1 + length; i++) {
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = i2; i < i2 + length; i++) {
            char ch = str2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i1, int i2, int length) {
        if (dp[i1][i2][length] != 0) {
            return dp[i1][i2][length] == 1;
        }
        if (str1.substring(i1, i1 + length).equals(str2.substring(i2, i2 + length))) {
            dp[i1][i2][length] = 1;
            return true;
        }
        if (!checkIfSimilar(i1, i2, length)) {
            dp[i1][i2][length] = 0;
            return false;
        }
        for (int i = 1; i < length; i++) {
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                dp[i1][i2][length] = 1;
                return true;
            }
            if (dfs(i1, length - i + i2, i) && dfs(i1 + i, i2, length - i)) {
                dp[i1][i2][length] = 1;
                return true;
            }
        }
        dp[i1][i2][length] = -1;
        return false;
    }

}
