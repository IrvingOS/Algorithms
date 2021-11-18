package top.irvingsoft.leetcode.code5;

/**
 * 最长回文子串
 *
 * @author TimeChaser
 * @since 2021/3/12 16:36
 */
public class Solution {

    /**
     * 暴力枚举法
     * <p>
     * j - i + 1 > maxLength && isPalindromeViolent(i, j, sArray)
     * 这一个短路判断是在暴力枚举法中节省时间的重要手段
     *
     * @author TimeChaser
     * @since 2021/3/12 18:19
     */
    public static String longestPalindromeViolent(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int length = s.length();
        int index = 0, maxLength = 1;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLength && isPalindromeViolent(i, j, sArray)) {
                    maxLength = j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, maxLength + index);
    }

    public static boolean isPalindromeViolent(Integer indexBegin, Integer indexEnd, char[] sArray) {

        while (indexBegin < indexEnd) {
            if (sArray[indexBegin] != sArray[indexEnd]) {
                return false;
            }
            indexBegin++;
            indexEnd--;
        }
        return true;
    }

    /**
     * 中心扩展法
     *
     * @author TimeChaser
     * @since 2021/3/12 18:19
     */
    public static String longestPalindromeViolentCenterExtension(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int length = s.length();
        int index = 0, maxLength = 1;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            int oddLength = countMaxLengthByCenterExtension(i, i, sArray);
            int evenLength = countMaxLengthByCenterExtension(i, i + 1, sArray);
            int currentMaxLength = Math.max(oddLength, evenLength);
            if (currentMaxLength > maxLength) {
                maxLength = currentMaxLength;
                index = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(index, maxLength + index);
    }

    public static int countMaxLengthByCenterExtension(Integer indexCenterLeft, Integer indexCenterRight, char[] sArray) {

        while (indexCenterLeft >= 0 && indexCenterRight < sArray.length && sArray[indexCenterLeft] == sArray[indexCenterRight]) {
            indexCenterLeft--;
            indexCenterRight++;
        }
        return indexCenterRight - indexCenterLeft - 1;
    }

    /**
     * 动态规划法
     *
     * @author TimeChaser
     * @since 2021/3/12 18:20
     */
    public static String longestPalindromeViolentDynamicProgramming(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        String subString = "";
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = b && dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && l + 1 > subString.length()) {
                    subString = s.substring(i, i + l + 1);
                }
            }
        }
        return subString;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        String palindromeViolent = longestPalindromeViolentCenterExtension(s);
        System.out.println(palindromeViolent);
    }
}
