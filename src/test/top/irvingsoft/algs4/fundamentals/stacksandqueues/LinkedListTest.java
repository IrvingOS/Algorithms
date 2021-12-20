package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Random;

class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Test
    void add() {
        init();
        linkedList.add(188);
        System.out.println(linkedList);
    }

    @Test
    void addFirst() {
        init();
        linkedList.addFirst(188);
        System.out.println(linkedList);
    }

    @Test
    void addLast() {
        init();
        linkedList.addLast(188);
        System.out.println(linkedList);
    }

    @Test
    void isEmpty() {
        init();
        System.out.println(linkedList.isEmpty());
    }

    @Test
    void iterator() {
        init();
        for (Integer item : linkedList) {
            System.out.println(item);
        }
    }

    @Test
    void remove() {
        init();
        linkedList.addFirst(1999);
        linkedList.addLast(1999);
        System.out.println(linkedList);
        linkedList.remove((Integer) 1999);
        System.out.println(linkedList);
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);
    }

    @Test
    void removeFirst() {
        init();
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
    }

    @Test
    void removeLast() {
        init();
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
    }

    @Test
    void reverse() {
        init();
        linkedList.reverse();
        System.out.println(linkedList);
    }

    @Test
    void size() {
        init();
        System.out.println(linkedList.size());
    }

    @Test
    void testRemove() {
        init();
        for (Integer integer : linkedList) {
            System.out.println(integer);
            linkedList.removeLast();
        }
    }

    private void init() {
        linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            linkedList.add(random.nextInt());
        }
        System.out.println(linkedList);
    }
}