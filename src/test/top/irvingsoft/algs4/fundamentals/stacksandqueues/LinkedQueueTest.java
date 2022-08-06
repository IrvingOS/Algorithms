package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class LinkedQueueTest {

    private LinkedQueue<String> queue;

    public static void main(String[] args) {
        LinkedQueueTest test = new LinkedQueueTest();
        test.queue = new LinkedQueue<>();
        test.enqueue(10);
        test.iterator();
        test.isEmpty();
        test.size();
        test.peek();
        test.dequeue();
        test.size();
        test.peek();
        test.iterator();
    }

    @Test
    void dequeue() {
        System.out.println("dequeue: " + queue.dequeue());
    }

    @Test
    void enqueue(int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            queue.enqueue(next);
        }
    }

    @Test
    void isEmpty() {
        System.out.println("isEmpty: " + queue.isEmpty());
    }

    @Test
    void iterator() {
        for (String s : queue) {
            System.out.print(s);
        }
        System.out.println();
    }

    @Test
    void peek() {
        System.out.println("peek: " + queue.peek());
    }

    @Test
    void size() {
        System.out.println("size: " + queue.size());
    }

}