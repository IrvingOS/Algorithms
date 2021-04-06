package top.irvingsoft.leetcode.code14;

/**
 * @description: 最长公共前缀
 *
 * 解题思路：
 *
 * 1. 横向比较：设第一个字符串为初始最长公共前缀，然后与第二个开始比较，每次得到的最长公共前缀依次与后面的字符串比较。当最长公共前缀为空字符串时退出比较。
 *
 * 2. 纵向比较：
 *
 *
 * @author: TimeChaser
 * @date: 2021/4/6 11:08
 */
public class Solution {

    public static String longestCommonPrefixTransverse(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        int count = strs.length;

        for (int i = 1; i < count; i++) {
            commonPrefix = longestCommonPrefixTransverse(commonPrefix, strs[i]);
            if ("".equals(commonPrefix)) {
                break;
            }
        }
        return commonPrefix;
    }

    public static String longestCommonPrefixTransverse(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
                index++;
        }
        return str1.substring(0, index);
    }

    public static String longestCommonPrefixLongitudinal(String[] strs) {

       return null;
    }

    public static void main(String[] args) {
        String[] strings = new String[] {
                " ", " b"
        };
        System.out.println(longestCommonPrefixTransverse(strings));
    }
}
