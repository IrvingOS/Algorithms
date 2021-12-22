package top.irvingsoft.exam.leetcode.weekly.leetcode272.code2109;

/**
 * 向字符串添加空格
 *
 * @author TimeChaser
 * @since 2021/12/21 15:44
 */
public class Solution {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                j++;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
