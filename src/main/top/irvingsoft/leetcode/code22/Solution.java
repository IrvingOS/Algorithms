package top.irvingsoft.leetcode.code22;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author TimeChaser
 * @since 2021/10/27 15:10
 */
public class Solution {

    public static void generate(StringBuilder sb, int left, int right, int max, List<String> result) {
        if (sb.length() == max * 2) {
            result.add(String.valueOf(sb));
            return;
        }
        if (left < max) {
            sb.append("(");
            generate(sb, left + 1, right, max, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generate(sb, left, right + 1, max, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    public static List<String> generateParenthesisDynamic(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add("");
        result.add(temp);
        temp = new ArrayList<>();
        temp.add("()");
        result.add(temp);
        for (int i = 2; i <= n; i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                ArrayList<String> list1 = result.get(j);
                ArrayList<String> list2 = result.get(i - j - 1);
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        temp.add("(" + s1 + ")" + s2);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
