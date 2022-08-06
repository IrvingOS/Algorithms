package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import java.util.*;

/**
 * @author TimeChaser
 * @since 2022/1/5 13:57
 */
public class OneQueueStack<T> {

    private final Queue<T> queue;

    public OneQueueStack() {
        queue = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        OneQueueStack<Integer> stack = new OneQueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.pop());
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public T pop() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        List<T> list = new ArrayList<>();
        while (queue.size() != 1) {
            list.add(queue.poll());
        }
        T e = queue.poll();
        for (T integer : list) {
            queue.offer(integer);
        }
        return e;
    }

    public void push(T e) {
        queue.offer(e);
    }

}
