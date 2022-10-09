package top.irvingsoft.leetcode.code856;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 括号的分数
 */
public class Solution {

    public int scoreOfParenthesesDivide(String s) {
        int n = s.length();
        if (n == 2) {
            return 1;
        }
        int bal = 0, len = 0;
        for (int i = 0; i < n; i++) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * scoreOfParenthesesDivide(s.substring(1, n - 1));
        } else {
            return scoreOfParenthesesDivide(s.substring(0, len)) + scoreOfParenthesesDivide(s.substring(len, n));
        }
    }

    public int scoreOfParenthesesStack(String s) {
        int n = s.length();
        if (n == 2) {
            return 1;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int top = stack.pop() + Math.max(2 * v, 1);
                stack.push(top);
            }
        }
        return stack.pop();
    }

    int index = 0;

    public int scoreOfParenthesesDfs(String s) {
        int res = 0;
        while (index < s.length() && s.charAt(index) == '(') {
            index++;
            if (s.charAt(index) == ')') {
                res += 1;
            } else {
                res += scoreOfParenthesesDivide(s) * 2;
            }
            index++;
        }
        return res;
    }
}
