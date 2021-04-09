package top.irvingsoft.leetcode.code28;

/**
 * @description: 实现 strStr() | indexOf()
 * @author: TimeChaser
 * @date: 2021/4/9 10:35
 */
public class Solution {

    public static int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int length = needle.length();
        for (int i = 0; i < n - length + 1; i++) {
            for (int k = 0; k < length; k++) {
                if (haystack.charAt(i + k) != needle.charAt(k)) {
                    break;
                }
                if (k == length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStrSubstring(String haystack, String needle) {
        int n = haystack.length();
        int length = needle.length();
        for (int i = 0; i < n - length + 1; i++) {
            if (haystack.substring(i, length + i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
