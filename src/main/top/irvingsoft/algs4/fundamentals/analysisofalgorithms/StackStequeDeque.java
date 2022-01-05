package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 一个 Stack 和一个 Steque 实现的双端队列
 * <p>
 * Steque 的 enqueue 方法定义模糊，如果是队头入队，则不需要辅助栈
 *
 * @author TimeChaser
 * @since 2022/1/5 14:22
 */
public class StackStequeDeque<T> {

    private final Stack<T>  stack;
    private final Steque<T> steque;
    private       int       n;

    public StackStequeDeque() {
        stack = new Stack<>();
        steque = new Steque<>();
    }

    public static void main(String[] args) {
        StackStequeDeque<Integer> deque = new StackStequeDeque<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        while (!deque.isEmpty()) {
            System.out.println(deque.pollLast());
        }
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerLast(6);
        deque.offerLast(7);
        while (!deque.isEmpty()) {
            System.out.println(deque.pollLast());
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void offer(T e) {
        offerLast(e);
    }

    public void offerFirst(T e) {
        Stack<T> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            steque.push(temp.pop());
        }
        while (!steque.isEmpty()) {
            stack.push(steque.pop());
        }
        steque.push(e);
        n++;
    }

    public void offerLast(T e) {
        stack.push(e);
        n++;
    }

    public T poll() {
        return pollFirst();
    }

    public T pollFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (steque.isEmpty()) {
            Stack<T> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            while (!temp.isEmpty()) {
                steque.push(temp.pop());
            }
        }
        n--;
        return steque.pop();
    }

    public T pollLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (stack.isEmpty()) {
            while (!steque.isEmpty()) {
                stack.push(steque.pop());
            }
        }
        n--;
        return stack.pop();
    }
}
