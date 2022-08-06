package top.irvingsoft.leetcode.code557;

/**
 * 反转字符串中的单词 ⅲ
 *
 * @author TimeChaser
 * @since 2021/11/15 10:57
 */
public class Solution {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = i - 1; j >= start; j--) {
                sb.append(s.charAt(j));
            }
            while (i < n && s.charAt(i) == ' ') {
                i++;
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
