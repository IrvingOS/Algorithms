package top.irvingsoft.leetcode.code3;

import java.util.HashSet;

/**
 * @description: 无重复字符的最长字串
 * @author: TimeChaser
 * @date: 2021/3/11 12:29
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> characterHashSet = new HashSet<>();

        int n = s.length();
        int rk = -1, longestLength = 0;
        for (int i = 0; i < n; i++) {

            if (i != 0) {
                characterHashSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !characterHashSet.contains(s.charAt(rk + 1))) {
                characterHashSet.add(s.charAt(rk + 1));
                rk++;
            }
            longestLength = Math.max(longestLength, characterHashSet.size());
        }
        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

/*
  @description:
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
 * @author: TimeChaser
 * @date: 2021/3/12 16:29
 */
