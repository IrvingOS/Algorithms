package top.irvingsoft.foroffer.code31;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author TimeChaser
 * @since 2021/12/2 11:17
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
