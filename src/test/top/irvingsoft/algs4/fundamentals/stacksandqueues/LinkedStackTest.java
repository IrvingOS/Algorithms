package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class LinkedStackTest {

    private LinkedStack<String> stack;

    public static void main(String[] args) {
        LinkedStackTest test = new LinkedStackTest();
        test.stack = new LinkedStack<>();
        test.push(5);
        test.isEmpty();
        test.size();
        test.peek();
        test.pop();
        test.peek();
        test.size();
        test.iterator();
    }

    @Test
    void isEmpty() {
        System.out.println("isEmpty: " + stack.isEmpty());
    }

    @Test
    void iterator() {
        for (String s : stack) {
            System.out.print(s);
        }
        System.out.println();
    }

    @Test
    void peek() {
        System.out.println("peek: " + stack.peek());
    }

    @Test
    void pop() {
        System.out.println("pop: " + stack.pop());
    }

    @Test
    void push(int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            stack.push(scanner.next());
        }
    }

    @Test
    void size() {
        System.out.println("size: " + stack.size());
    }

}