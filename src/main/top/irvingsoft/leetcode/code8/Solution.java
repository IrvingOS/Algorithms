package top.irvingsoft.leetcode.code8;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转换整数（atoi）
 *
 * @author TimeChaser
 * @since 2021/10/31 12:24
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(myAtoiAutomaton("  0000000000012345678"));
        System.out.println(myAtoiAutomaton("+1"));
        System.out.println(myAtoiAutomaton("0"));
        System.out.println(myAtoiAutomaton("42"));
        System.out.println(myAtoiAutomaton("   -42"));
        System.out.println(myAtoiAutomaton("4193 with words"));
        System.out.println(myAtoiAutomaton("words and 987"));
        System.out.println(myAtoiAutomaton("214748364821474836482147483648"));
        System.out.println(myAtoiAutomaton("-214748364821474836482147483648"));
    }

    /**
     * 存在异常
     *
     * @since 2021/10/31 14:03
     */
    public static int myAtoiAutomaton(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public static int myAtoiTraverse(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 定位到第一个有效位
        int index = 0;
        while (index < length && chars[index] == ' ') {
            index++;
        }
        // 数组下标溢出
        if (index == length) {
            return 0;
        }
        // 符号判断
        boolean positive = true;
        if (chars[index] == '-') {
            positive = false;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        int value = 0;
        while (index < length) {
            if (chars[index] < '0' || chars[index] > '9') {
                break;
            }
            int temp = value;
            value = value * 10 + chars[index] - '0';
            // 整型溢出
            if (temp != value / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return positive ? value : -value;
    }

    static class Automaton {

        private static final Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start, signed", "in_number", "end"});
            put("signed", new String[]{"end, end", "in_number", "end"});
            put("in_number", new String[]{"end, end", "in_number", "end"});
            put("end", new String[]{"end, end", "end", "end"});
        }};
        public long ans = 0;
        public int sign = 1;
        private String state = "start";

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }

    }

}
