package top.irvingsoft.leetcode.code1576;

/**
 * 替换所有的问号
 *
 * @author TimeChaser
 * @since 2022/1/5 10:10
 */
public class Solution {

    public String modifyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                char ch = 'a';
                while ((i > 0 && sb.charAt(i - 1) == ch) || (i < n - 1 && s.charAt(i + 1) == ch)) {
                    ch++;
                }
                sb.append(ch);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
