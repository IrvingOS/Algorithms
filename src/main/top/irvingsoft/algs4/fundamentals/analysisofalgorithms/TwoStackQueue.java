package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author TimeChaser
 * @since 2022/1/5 13:52
 */
public class TwoStackQueue<T> {

    private final Stack<T> stackIn;
    private final Stack<T> stackOut;

    public TwoStackQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(5);
        System.out.println(queue.poll());
        queue.offer(6);
        System.out.println(queue.poll());
        queue.offer(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public void offer(T e) {
        stackIn.push(e);
    }

    public T poll() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

}
