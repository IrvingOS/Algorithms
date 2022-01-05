package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author TimeChaser
 * @since 2022/1/5 16:15
 */
public class ThreeStackDeque<T> {

    private final Stack<T> stackFirst;
    private final Stack<T> stackMiddle;
    private final Stack<T> stackLast;
    private       int      n;

    public ThreeStackDeque() {
        stackFirst = new Stack<>();
        stackMiddle = new Stack<>();
        stackLast = new Stack<>();
        n = 0;
    }

    public static void main(String[] args) {
        ThreeStackDeque<Integer> deque = new ThreeStackDeque<>();
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
        stackFirst.push(e);
        n++;
    }

    public void offerLast(T e) {
        stackLast.push(e);
        n++;
    }

    public T poll() {
        return pollFirst();
    }

    public T pollFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (stackFirst.isEmpty()) {
            int half = stackLast.size() / 2;
            while (half-- > 0) {
                stackMiddle.push(stackLast.pop());
            }
            while (!stackLast.isEmpty()) {
                stackFirst.push(stackLast.pop());
            }
            while (!stackMiddle.isEmpty()) {
                stackLast.push(stackMiddle.pop());
            }
        }
        n--;
        return stackFirst.pop();
    }

    public T pollLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (stackLast.isEmpty()) {
            int half = stackFirst.size() / 2;
            while (half-- > 0) {
                stackMiddle.push(stackFirst.pop());
            }
            while (!stackFirst.isEmpty()) {
                stackLast.push(stackFirst.pop());
            }
            while (!stackMiddle.isEmpty()) {
                stackFirst.push(stackMiddle.pop());
            }
        }
        n--;
        return stackLast.pop();
    }
}
