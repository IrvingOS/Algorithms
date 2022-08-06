package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.HashMap;
import java.util.Map;

/**
 * 堆栈工具类
 *
 * @author TimeChaser
 * @since 2021/12/14 10:12
 */
public class Stacks {

    /**
     * 运算符优先级
     */
    private static final Map<Character, Integer> MAP = new HashMap<Character, Integer>(8) {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public static double calculate(String str) {
        char[] array = str.replace(" ", "").toCharArray();
        int n = array.length;
        Stack<Double> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        nums.push(0.0);
        for (int i = 0; i < n; i++) {
            char ch = array[i];
            if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calculate(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else {
                if (ch == '.' || (ch >= '0' && ch <= '9')) {
                    StringBuilder numBuilder = new StringBuilder();
                    int j = i;
                    while (j < n && (array[j] == '.' || (array[j] >= '0' && array[j] <= '9'))) {
                        numBuilder.append(array[j++]);
                    }
                    nums.push(Double.parseDouble(numBuilder.toString()));
                    i = j - 1;
                } else {
                    if (i > 0 && (array[i - 1] == '(' || array[i - 1] == '+' || array[i - 1] == '-')) {
                        nums.push(0.0);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        char prev = ops.peek();
                        if (MAP.get(prev) >= MAP.get(ch)) {
                            calculate(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.push(ch);
                }
            }
        }
        while (!ops.isEmpty() && ops.peek() != '(') {
            calculate(nums, ops);
        }
        return nums.pop();
    }

    public static double calculateAddAndSub(String str) {
        Stack<Double> ops = new Stack<>();
        ops.push(1.0);
        double sign = 1;
        double result = 0;
        int n = str.length();
        int i = 0;
        while (i < n) {
            if (str.charAt(i) == ' ') {
                i++;
            } else if (str.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (str.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (str.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (str.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                int lo = i;
                while (i < n && ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.')) {
                    i++;
                }
                result += sign * Double.parseDouble(str.substring(lo, i));
            }
        }
        return result;
    }

    /**
     * Compute arithmetic expression.
     *
     * @param str arithmetic expression, should be complete brackets.
     * @return double
     */
    public static double calculateCompleteExpression(String str) {
        int n = str.length();
        Stack<Character> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
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
                while (i < n && ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.')) {
                    i++;
                }
                values.push(Double.parseDouble(str.substring(lo, i)));
            }
        }
        return values.pop();
    }

    /**
     * Complete parentheses.
     * <p>
     * It will delete the spaces in the expression.
     *
     * @param str Incomplete parentheses expression
     * @return java.lang.String
     */
    public static String completeParentheses(String str) {
        int n = str.length();
        Stack<String> combinations = new Stack<>();
        Stack<Character> ops = new Stack<>();
        boolean continuous = false;
        int i = 0;
        while (i < n) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                ops.push(ch);
                continuous = false;
            } else if (ch >= '0' && ch <= '9') {
                if (continuous) {
                    combinations.push(combinations.pop() + ch);
                } else {
                    combinations.push(String.valueOf(ch));
                    continuous = true;
                }
            } else if (ch == '(' || ch == ')') {
                continuous = false;
                String comb2 = combinations.pop();
                String comb1 = combinations.pop();
                Character op = ops.pop();
                combinations.push("(" + comb1 + op + comb2 + ")");
            }
            i++;
        }
        return combinations.pop();
    }

    /**
     * Are parentheses valid?
     *
     * @param str parentheses
     * @return boolean
     */
    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
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

    private static void calculate(Stack<Double> nums, Stack<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) {
            return;
        }
        double b = nums.pop(), a = nums.pop();
        char op = ops.pop();
        double ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.push(ans);
    }

}
