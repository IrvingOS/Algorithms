package top.irvingsoft.leetcode.code3;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @author TimeChaser
 * @since 2021/3/11 12:29
 */
public class Solution {

    /**
     * 滑动窗口 + 双指针
     * <p>
     * 慢指针负责删除前面可能重复的字符，快指针负责尽可能多的将后面的字符加到集合中
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> substringSet = new HashSet<>();
        int length = s.length();
        int rk = 0, result = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                substringSet.remove(s.charAt(i - 1));
            }
            while (rk < length && !substringSet.contains(s.charAt(rk))) {
                substringSet.add(s.charAt(rk));
                rk++;
            }
            result = Math.max(result, substringSet.size());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

/*
 *
 * Set:
 *      定义 equals();
 *      确保对象的唯一性，不保证维护元素的次序
 * HashSet:
 *      定义 hashCode();
 *      为快速查找而设计
 * TreeSet:
 *      实现 Comparable 接口
 *      保持次序的 Set，可以从 Set 中提取有序的序列
 * LinkedHashSet:
 *      定义 hashCode();
 *      具有 HashSet 的查询速度
 *      使用链表维护元素插入的顺序
 *
 * @author TimeChaser
 * @since 2021/3/12 16:29
 */
