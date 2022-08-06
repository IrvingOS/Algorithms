package top.irvingsoft.leetcode.code521;

/**
 * 最长特殊序列 i
 *
 * @author TimeChaser
 * @since 2022/3/8 11:56 AM
 */
public class Solution {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
