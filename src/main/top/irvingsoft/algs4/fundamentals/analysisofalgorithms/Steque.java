package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author TimeChaser
 * @since 2022/1/5 14:05
 */
public class Steque<T> {

    private final Stack<T> stackIn;
    private final Stack<T> stackOut;
    private int n;

    public Steque() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
        n = 0;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.push(4);
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        steque.push(5);
        System.out.println(steque.pop());
        steque.push(6);
        System.out.println(steque.pop());
        steque.push(7);
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
    }

    public void enqueue(T e) {
        push(e);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T pop() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        n--;
        return stackOut.pop();
    }

    public void push(T e) {
        n++;
        stackIn.push(e);
    }

}
