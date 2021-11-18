package top.irvingsoft.leetcode.code71;

import java.util.Stack;

/**
 * 简化路径
 *
 * @author TimeChaser
 * @since 2021/11/5 17:49
 */
public class Solution {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (String p : path.split("/")) {
            if (!stack.isEmpty() && p.equals("src")) {
                stack.pop();
            } else if (!"src".contains(p)) {
                stack.push(p);
            }
        }
        for (String s : stack) {
            result.append("/").append(s);
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
