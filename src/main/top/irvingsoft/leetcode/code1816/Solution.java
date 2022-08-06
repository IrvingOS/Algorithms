package top.irvingsoft.leetcode.code1816;

/**
 * 截断句子
 *
 * @author TimeChaser
 * @since 2021/12/6 14:36
 */
public class Solution {

    public String truncateSentence(String s, int k) {
        int n = s.length();
        int count = 0;
        int end = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }

}
