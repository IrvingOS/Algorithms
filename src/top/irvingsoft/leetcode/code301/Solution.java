package top.irvingsoft.leetcode.code301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 删除无效的括号
 *
 * @author TimeChaser
 * @since 2021/10/27 15:44
 */
public class Solution {

    /**
     * 回溯 + 剪枝
     *
     * @author TimeChaser
     * @since 2021/10/27 18:42
     */
    public static List<String> removeInvalidParenthesesRecursion(String s) {
        int leftRemove = 0;
        int rightRemove = 0;

        // 计算必须去掉的左括号和右括号的个数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRemove++;
            } else if (s.charAt(i) == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();
        helper(s, 0, leftRemove, rightRemove, result);
        return result;
    }

    /**
     * 递归
     *
     * @param str         删除后的字符串
     * @param start       新的起始下标
     * @param leftRemove  多余的左括号数
     * @param rightRemove 多余的右括号数
     * @param result      结果
     */
    private static void helper(String str, int start, int leftRemove, int rightRemove, List<String> result) {
        if (leftRemove == 0 && rightRemove == 0) {
            if (isValid(str)) {
                result.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            // 重复的符号，跳过
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 剩余的字符无法满足去掉的数量的要求，直接返回
            if (leftRemove + rightRemove > str.length() - i) {
                return;
            }
            // 去掉左括号或者右括号
            String newString = str.substring(0, i) + str.substring(i + 1);
            if (leftRemove > 0 && str.charAt(i) == '(') {
                helper(newString, i, leftRemove - 1, rightRemove, result);
            }
            if (rightRemove > 0 && str.charAt(i) == ')') {
                helper(newString, i, leftRemove, rightRemove - 1, result);
            }
        }
    }

    public static List<String> removeInvalidParenthesesDfs(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> curSet = new HashSet<>();

        curSet.add(s);
        while (true) {
            for (String str : curSet) {
                if (isValid(str)) {
                    result.add(str);
                }
            }
            if (result.size() > 0) {
                return result;
            }
            HashSet<String> nextSet = new HashSet<>();
            for (String str : curSet) {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            curSet = nextSet;
        }
    }

    private static boolean isValid(String str) {
        int leftCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftCount++;
            } else if (str.charAt(i) == ')') {
                leftCount--;
                if (leftCount < 0) {
                    return false;
                }
            }
        }
        return leftCount == 0;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParenthesesRecursion(")d))"));
    }
}
