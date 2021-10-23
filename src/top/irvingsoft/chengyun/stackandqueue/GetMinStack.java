package top.irvingsoft.chengyun.stackandqueue;

import java.util.Stack;

/**
 * Page 19
 * <p>
 * 设计一个有 getMin 功能的栈
 * <p>
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * <p>
 * 1. pop、push、getMin 操作的时间复杂度都是 O(1)
 * 2. 设计的栈类型可以使用现成的栈结构
 * <p>
 * 思路一：
 * 在压栈前，即将入栈数据 小于等于 当前最小值时，在 stackData 和 stackMin 中同时压入数据。
 * 否则，则只在 stackData 中压入数据。
 * 在出栈后，如果出栈数据 等于 当前最小值，stackMin 弹出当前最小值。
 * <p>
 * 思路二：
 * 在压栈前，即将入栈数据 小于等于 当前最小值时，在 stackData 和 stackMin 中同时压入数据。
 * 否则，则在 stackData 中压入数据，在 stackMin 中再次压入当前最小值。
 * 在出栈后，同步弹出 stackMin 的当前最小值。
 *
 * @author TimeChaser
 * @date 2021/8/8 10:39
 */
public class GetMinStack {

    private final Stack<Integer> stackData;
    private final Stack<Integer> stackMin;

    public GetMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public static void main(String[] args) {

        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(5);
        System.out.println(getMinStack.getMin());
        getMinStack.push(7);
        System.out.println(getMinStack.getMin());
        getMinStack.push(2);
        System.out.println(getMinStack.getMin());
        getMinStack.push(1);
        System.out.println(getMinStack.getMin());
        getMinStack.push(4);
        System.out.println(getMinStack.getMin());
    }

    public int pop() {

        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        int data = this.stackData.pop();
        if (data == this.getMin()) {
            this.stackMin.pop();
        }
        return data;
    }

    public void push(int data) {

        if (this.stackMin.isEmpty() || data <= this.getMin()) {
            this.stackMin.push(data);
        }
        this.stackData.push(data);
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return this.stackMin.peek();
    }
}
