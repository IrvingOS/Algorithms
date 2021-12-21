package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Random;

class ArrayDequeTest {

    private ArrayDeque<Integer> deque;
    private boolean             init;

    @Test
    void isEmpty() {
        init();
        System.out.println(deque.isEmpty());
    }

    @Test
    void iterator() {
        init();
        for (Integer item : deque) {
            System.out.println(item);
        }
    }

    @Test
    void offer() {
        init();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            deque.offer(random.nextInt());
            System.out.println(deque);
        }
    }

    @Test
    void offerFirst() {
        init();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            deque.offerFirst(random.nextInt());
            System.out.println(deque);
        }
    }

    @Test
    void offerLast() {
        init();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            deque.offerLast(random.nextInt());
            System.out.println(deque);
        }
    }

    @Test
    void poll() {
        init();
        for (int i = 0; i < 10; i++) {
            System.out.println(deque);
            System.out.println(deque.poll());
        }
    }

    @Test
    void pollFirst() {
        init();
        for (int i = 0; i < 10; i++) {
            System.out.println(deque);
            System.out.println(deque.pollFirst());
        }
    }

    @Test
    void pollLast() {
        init();
        for (int i = 0; i < 10; i++) {
            System.out.println(deque);
            System.out.println(deque.pollLast());
        }
        offerFirst();
        offerFirst();
        for (int i = 0; i < 10; i++) {
            System.out.println(deque);
            System.out.println(deque.pollLast());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(deque);
            System.out.println(deque.pollLast());
        }
    }

    @Test
    void size() {
        init();
        System.out.println(deque.size());
    }

    private void init() {
        if (init) {
            return;
        }
        deque = new ArrayDeque<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            deque.offer(random.nextInt());
        }
        System.out.println(deque);
        init = true;
    }
}