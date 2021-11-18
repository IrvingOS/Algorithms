package top.irvingsoft.leetcode.code155;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author TimeChaser
 * @since 2021/11/14 20:24
 */
public class Solution {
}

class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
        if (this.minStack.isEmpty() || this.getMin() >= val) {
            this.minStack.push(val);
        }
    }

    public void pop() {
        if (this.top() == this.getMin()) {
            this.minStack.pop();
        }
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}