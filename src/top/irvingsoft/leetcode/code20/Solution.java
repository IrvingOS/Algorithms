package top.irvingsoft.leetcode.code20;

import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 解题思路：
 * 遍历到左括号入栈，右括号则出栈匹配
 * <p>
 * 可能出现的问题：
 * 1. 第一字符为右括号，此时栈为空，出栈报错。所以每次出栈前都要判断栈是否为空，为空则匹配出错
 * 2. 字符全为左括号，在匹配过程中只进行了入栈操作，没有进行匹配从而没有判断为 false。所以在最后得判断栈是否为空，不为空则匹配出错。
 *
 * @author TimeChaser
 * @date 2021/4/7 13:09
 */
public class Solution {

    public static boolean isValid(String s) {

        if (s.length() == 0) {
            return true;
        }
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    characterStack.push(c);
                    break;
                case ')': {
                    if (characterStack.size() == 0) {
                        return false;
                    }
                    Character pop = characterStack.pop();
                    if (pop != '(') {
                        return false;
                    }
                }
                break;
                case '}': {
                    if (characterStack.size() == 0) {
                        return false;
                    }
                    Character pop = characterStack.pop();
                    if (pop != '{') {
                        return false;
                    }
                }
                break;
                case ']': {
                    if (characterStack.size() == 0) {
                        return false;
                    }
                    Character pop = characterStack.pop();
                    if (pop != '[') {
                        return false;
                    }
                }
                break;
                default:
                    return false;
            }
        }
        return characterStack.size() == 0;
    }

    public static void main(String[] args) {

        System.out.println(isValid("]]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
