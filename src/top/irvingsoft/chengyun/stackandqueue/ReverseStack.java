package top.irvingsoft.chengyun.stackandqueue;

import java.util.Stack;

/**
 * Page 26
 * <p>
 * 逆序栈
 * <p>
 * 先进先出
 *
 * @author TimeChaser
 * @date 2021/8/8 11:26
 */
public class ReverseStack {

    private final Stack<Integer> stack;

    public ReverseStack() {
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {

        ReverseStack reverseStack = new ReverseStack();
        reverseStack.push(5);
        reverseStack.push(1);
        reverseStack.push(3);
        reverseStack.push(8);
        reverseStack.push(6);
        reverseStack.reverse();
        System.out.println(reverseStack.pop());
        System.out.println(reverseStack.popReverse());
    }

    public void push(int data) {
        this.stack.push(data);
    }

    public int popReverse() {

        if (this.stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return getAndRemoveLastElement(this.stack);
    }

    private int getAndRemoveLastElement(Stack<Integer> stack) {

        int data = stack.pop();
        if (stack.isEmpty()) {
            return data;
        }
        int result = getAndRemoveLastElement(this.stack);
        stack.push(data);
        return result;
    }

    public int pop() {

        if (this.stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return this.stack.pop();
    }

    public void reverse() {

        if (this.stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        reverse(this.stack);
    }

    private void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int data = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(data);
    }
}
