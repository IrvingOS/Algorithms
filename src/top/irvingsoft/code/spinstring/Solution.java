package top.irvingsoft.code.spinstring;

import java.util.Arrays;

/**
 * @description: 旋转字符串
 * @author: TimeChaser
 * @date: 2021/7/7 14:00
 */
public class Solution {

    /**
     * @description: double 模式串后通过 indexOf 进行目标匹配
     * 时间复杂度：O(n)
     * double + indexOf(contains)
     * String.indexOf() 不是使用的 KMP 算法，而是先找到第一个与目标第一个字符匹配的字符，
     * 然后进行后续的字符对比，若后续对比失败，则找下一个与目标第一个字符匹配的字符。
     * @author: TimeChaser
     * @date: 2021/7/7 13:56
     */
    public static boolean verifyByIndexOf(String source, String target) {

        if (source.length() != target.length()) {
            return false;
        }
        return (source + source).contains(target);
    }

    /**
     * @description:
     * @author: TimeChaser
     * @date: 2021/7/7 14:01
     */
    public static boolean verifyByK(String source, String target) {

        if (source.length() != target.length()) {
            return false;
        }
        if ("".equals(source) || "".equals(target)) {
            return true;
        }
        return kmp(source + source, target);
    }

    public static boolean kmp(String source, String target) {
        int[] next = new int[target.length() + 1];
        buildNext(target, next);
        System.out.println(Arrays.toString(next));
        int i = 1, j = 1;
        while (i <= source.length() && j <= target.length()) {

            if (j == 0 || source.charAt(i - 1) == target.charAt(j - 1)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j > target.length();
    }

    /**
     * @description: 根据模式串构造 Next 数组（有限状态机）
     * 有限状态机指示匹配失败后，指针移动的目标
     * Next 数组的构造过程是一个动态规划的过程，前缀每个字符的匹配情况都影响到后续字符的匹配
     * 每次进行两个索引上的字符对比时都是期待当前为最长相同前后缀，
     * 当 j != 0，且两个索引上的字符不相同时，指针 j 回退到当前最长相同前后缀前缀的后续第一个字符，看此时是否构成相同前后缀（缩短相同前后缀后再次期待当前最长相同前后缀）
     * 所以 Next 数组存储的是当前字符之前的最长相同前后缀的长度值 + 1，以便在后续字符匹配失败时可以定位到（存在相同前后缀）的自己的索引上
     * 每次回退到 j == 0 时，表示当前字符前不存在相同前后缀
     * @author: TimeChaser
     * @date: 2021/7/7 17:02
     */
    public static void buildNext(String target, int[] next) {

        int i = 1, j = 0;
        next[1] = 0;
        while (i < target.length()) {
            if (j == 0 || target.charAt(i - 1) == target.charAt(j - 1)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(verifyByK("", ""));
    }
}