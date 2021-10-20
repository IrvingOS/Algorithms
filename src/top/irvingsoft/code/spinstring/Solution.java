package top.irvingsoft.code.spinstring;

/**
 * 旋转字符串
 * <br/>
 * double 原串后看目标串是否是原串的子串
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/7/7 14:00
 */
public class Solution {

    /**
     * double 模式串后通过 indexOf 进行目标匹配
     * <br/>
     * 时间复杂度：O(n)
     * <br/>
     * double + indexOf(contains)
     * <br/>
     * String.indexOf() 不是使用的 KMP 算法，而是先找到第一个与目标第一个字符匹配的字符，
     * <br/>
     * 然后进行后续的字符对比，若后续对比失败，则找下一个与目标第一个字符匹配的字符。
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/7/7 13:56
     */
    public static boolean verifyByIndexOf(String source, String target) {

        if (source.length() != target.length()) {
            return false;
        }
        return (source + source).contains(target);
    }

    /**
     * 通过 KMP 算法校验
     * <br/>
     * 时间复杂度 O(m+n)
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/7/7 14:01
     */
    public static boolean verifyByK(String source, String target) {

        if (source.length() != target.length()) {
            return false;
        }
        if ("".equals(source)) {
            return true;
        }
        return kmp(source + source, target);
    }

    /**
     * 时间复杂度 O(m+n)
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 10:49
     */
    public static boolean kmp(String source, String target) {

        int[] next = new int[target.length() + 1];
        buildNext(target, next);
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
     * 根据模式串构造 Next 数组（有限状态机）
     * <br/>
     * 有限状态机指示匹配失败后，指针移动的目标
     * <br/>
     * 前缀的最长相同前后缀长度 < 前缀长度
     * <br/>
     * Next 数组的构造过程是一个动态规划的过程，前缀每个字符的匹配情况都影响到后续字符的匹配
     * <br/>
     * 每次进行两个索引上的字符对比时都是期待当前为最长相同前后缀，
     * <br/>
     * 当 j != 0，且两个索引上的字符不相同时，指针 j 回退到当前最长相同前后缀前缀的后续第一个字符，看此时是否构成相同前后缀（缩短相同前后缀后再次期待当前最长相同前后缀）
     * <br/>
     * 所以 Next 数组存储的是当前字符之前的最长相同前后缀的长度值 + 1，以便在后续字符匹配失败时可以定位到（存在相同前后缀）的自己的索引上
     * <br/>
     * 每次回退到 j == 0 时，表示当前字符前不存在相同前后缀，此刻匹配失败时回退到第一个字符
     * <br/>
     * 时间复杂度 O(m)
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/7/7 17:02
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

        System.out.println(verifyByK("abcde", "deabc"));
        System.out.println(verifyByK("", ""));
        System.out.println(verifyByIndexOf("", ""));
    }
}