package top.irvingsoft.algs4.fundamentals.stacksandqueues;

/**
 * 堆栈工具类
 *
 * @author TimeChaser
 * @since 2021/12/14 10:12
 */
public class StackUtils {

    /**
     * Is the popped sequence valid?
     *
     * @param pushed pushed sequence
     * @param popped popped sequence
     * @return boolean
     */
    public static <T> boolean validateStackSequences(T[] pushed, T[] popped) {
        Stack<T> stack = new Stack<>();
        int indexOfPopped = 0;
        for (T t : pushed) {
            stack.push(t);
            while (!stack.isEmpty() && stack.peek().equals(popped[indexOfPopped])) {
                stack.pop();
                indexOfPopped++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Are parentheses valid?
     *
     * @param s parentheses
     * @return boolean
     */
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Compute arithmetic expression.
     *
     * @param s arithmetic expression, should be complete brackets.
     * @return double
     */
    public static double calculateCompleteExpression(String s) {
        int n = s.length();
        Stack<Character> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                ops.push(ch);
            } else if (ch == ')') {
                Character op = ops.pop();
                Double value = values.pop();
                if (op == '+') {
                    value = values.pop() + value;
                } else if (op == '-') {
                    value = values.pop() - value;
                } else if (op == '*') {
                    value = values.pop() * value;
                } else if (op == '/') {
                    value = values.pop() / value;
                }
                values.push(value);
            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                int lo = i;
                while (i < n && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.')) {
                    i++;
                }
                values.push(Double.parseDouble(s.substring(lo, i)));
            }
        }
        return values.pop();
    }

    public static double calculateAddAndSub(String s) {
        Stack<Double> ops = new Stack<>();
        ops.push(1.0);
        double sign = 1;
        double result = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                int lo = i;
                while (i < n && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.')) {
                    i++;
                }
                result += sign * Double.parseDouble(s.substring(lo, i));
            }
        }
        return result;
    }
}
