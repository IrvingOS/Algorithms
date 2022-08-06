package top.irvingsoft.leetcode.code1614;

/**
 * 括号的最大嵌套深度
 *
 * @author TimeChaser
 * @since 2022/1/7 10:48
 */
public class Solution {

    public int maxDepth(String s) {
        int maxDepth = 0;
        int size = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                size++;
                maxDepth = Math.max(size, maxDepth);
            } else if (c == ')') {
                size--;
            }
        }
        return maxDepth;
    }

}
