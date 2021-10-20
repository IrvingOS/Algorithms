package top.irvingsoft.chengyun.stackandqueue;

import java.util.Stack;

/**
 * Page 23
 * <p>
 * 两个栈组成的队列
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/8/8 10:59
 */
public class TwoStacksQueue {

    private final Stack<Integer> stackPush;
    private final Stack<Integer> stackPop;

    public TwoStacksQueue() {

        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public static void main(String[] args) {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(9);
        twoStacksQueue.add(5);
        twoStacksQueue.add(2);
        System.out.println(twoStacksQueue.peek());
        twoStacksQueue.add(7);

        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        twoStacksQueue.add(2);
        twoStacksQueue.add(7);
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
    }

    public void add(int data) {
        this.stackPush.push(data);
    }

    public int poll() {

        if (this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        } else if (this.stackPop.isEmpty()) {
            while (!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    public int peek() {

        if (this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        } else if (this.stackPop.isEmpty()) {
            while (!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }

}
