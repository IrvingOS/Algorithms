package top.irvingsoft.foroffer.code30;

import java.util.Stack;

class MinStack {

    private final Stack<Integer> minStack;
    private final Stack<Integer> numStack;

    public MinStack() {
        this.numStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public int min() {
        return minStack.peek();
    }

    public void pop() {
        if (numStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public void push(int x) {
        numStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public int top() {
        return numStack.peek();
    }

}

/**
 * 包含 min 函数的栈
 *
 * @author TimeChaser
 * @since 2021/12/1 12:59
 */
public class Solution {

}